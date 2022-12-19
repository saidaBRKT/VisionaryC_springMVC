package com.visionaryCrofting.demo.Controller;


import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.service.CommandService;
import com.visionaryCrofting.demo.service.implementation.CommandServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommandContrroler {

    @Autowired
    CommandService commandService;

}
