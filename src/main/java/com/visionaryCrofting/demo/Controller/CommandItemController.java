package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.entity.StatusCmd;
import com.visionaryCrofting.demo.service.ClientService;
import com.visionaryCrofting.demo.service.CommanItemService;
import com.visionaryCrofting.demo.service.CommandService;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class  CommandItemController {
    @Autowired
    CommanItemService commanItemService;

    @Autowired
    ClientService clientService;

    @Autowired
    CommandService commandService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/AddCommandeItem",method = RequestMethod.POST)
    public String addCommandeItem(@ModelAttribute CommandeItem commandeItem){
        commanItemService.save(commandeItem);
        return "redirect:/ClientProducts";
    }

    @GetMapping("/pannier")
    public String allCommandeItems (Model model,HttpSession session){
        return "pannier";
    }



}
