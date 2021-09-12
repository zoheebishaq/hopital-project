package fr.zoheeb.hopital.controller;

import fr.zoheeb.hopital.service.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HopitalController {

    private HopitalService hopitalService;

    @Autowired
    public HopitalController(HopitalService hopitalService){
        this.hopitalService =hopitalService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}
