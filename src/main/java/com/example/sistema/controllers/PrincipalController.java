package com.example.sistema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrincipalController {

    @GetMapping("/administrativo")
    public String AcessarPrincipal() {
        return "administrativo/home";
    }
    
}
