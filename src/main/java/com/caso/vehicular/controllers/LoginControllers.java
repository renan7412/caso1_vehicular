package com.caso.vehicular.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginControllers {

    @GetMapping("/formularioLogin")
    public String muestroPropioLogin() {
        return "login";
    }
}
