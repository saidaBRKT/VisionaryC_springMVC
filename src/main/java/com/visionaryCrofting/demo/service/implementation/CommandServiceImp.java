package com.visionaryCrofting.demo.service.implementation;
import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.Repositories.CommandeRepository;
import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.StatusCmd;
import com.visionaryCrofting.demo.service.ClientService;
import com.visionaryCrofting.demo.service.CommanItemService;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.visionaryCrofting.demo.service.CommandService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommandServiceImp implements CommandService{
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    ProductService productService;
    @Autowired
    CommanItemService commanItemService;
    // get all commande
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }
    // get commande by id
    public Commande getCommandeById(Long id){
        Commande stest = commandeRepository.findById(id).orElse(null);
        if (stest == null){
            throw new IllegalStateException("Commande not found");
        }else{
            return stest;
        }
    }
    // get commande by ref
    public Commande getCommandeByRef(String ref){
        return commandeRepository.findByRef(ref);
    }
    // add commande
    public Commande addCommande(Commande commande){
        // checkin if commande exist
        if (commandeRepository.findByRef(commande.getRef()) != null){
            throw new IllegalStateException("Commande existe déja");
            // checking if command values are empty
        }else if (commande.getRef() == null || commande.getRef().isEmpty() || commande.getRef().isBlank()){
            throw new IllegalStateException("please fill all the inputs");
        }else{
            return commandeRepository.save(commande);
        }
    }
    // delete commande
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande deleted";
    }

    @Override
    public Commande getCommandeInProgress(Long id_cl, StatusCmd statusCmd) {
        return commandeRepository.getCommadeClient(id_cl,statusCmd);
    }

    @Override
    public Commande save(Commande commande) {
        return null;
        //return commandeRepository.save(commande);
    }

    @Override
    public Commande saveCommand(Commande commande) {

        String email = commande.getClient().getEmail();
        if (email == "" || email == null) return null;
        commande.setClient(clientService.findByEmail(email));

        if (commande.getCommandeItems().size()==0) return null;
        commande.setStatus(StatusCmd.Validate);

        List<CommandeItem> commandeItemStreams = commande.getCommandeItems().stream().map(commandeItem -> {
            Product product = productService.findByRef(commandeItem.getProduct().getRef());
            commandeItem.setPrice(product.getPrice()*commandeItem.getQuantity());
            commandeItem.setRef(UUID.randomUUID().toString());
            commandeItem.setProduct(product);
            return commandeItem;
        }).collect(Collectors.toList());

        double total = 0D;
        for (CommandeItem commandeItem : commandeItemStreams)
        total+= commandeItem.getPrice();
        commande.setPrixTotal(total);
        //commande.getCommandeItems().clear();
        commande.setRef(UUID.randomUUID().toString());
        commande.setDate(LocalDate.now());
        Commande commandSave = commandeRepository.save(commande);

        commandeItemStreams.forEach(commandeItem -> {
            System.out.println(commandeItem);
            commandeItem.setCommande(commandSave);
            CommandeItem item = commanItemService.save(commandeItem);
            commandSave.getCommandeItems().add(item);
        });

        return commandSave;
    }
}
