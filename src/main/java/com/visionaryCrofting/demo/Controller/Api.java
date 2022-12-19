package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/command")
public class Api {

    @Autowired
    CommandService commandService;
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Commande save(@RequestBody Commande commande){
        Commande commande1 =  commandService.saveCommand(commande);
        return commande1 ;
    }
}
