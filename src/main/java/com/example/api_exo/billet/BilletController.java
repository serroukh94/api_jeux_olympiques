package com.example.api_exo.billet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billets")
public class BilletController {

    private final BilletService billetService;

    @Autowired
    public BilletController(BilletService billetService) {
        this.billetService = billetService;
    }

    @PostMapping("/acheter")
    public Billet acheterBillet(@RequestBody Billet billet) {
        return billetService.acheterBillet(billet);
    }

}
