package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientRessource {

    @Autowired
    ClientService clientService;

//    @GetMapping(path="/Client")
//    public String index(){
//        return "ClientProduct";
//    }

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{client_id}")
    public Optional<Client> getClientById(@PathVariable Long client_id){
        Optional<Client> client = clientService.getOnById(client_id);
        if(client.isPresent()){
            return client;
        }else{
            throw new IllegalStateException("Id non trouvé");
        }
    }

    @PostMapping("/")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @PutMapping("{client_id}")
    public Client updateClient(@PathVariable Long client_id,@RequestBody Client client){
        return clientService.updateClient(client_id,client);
    }
}
