package br.com.dicionariofutebolistico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/diciofut-login")
    public String loginPage() {
        return "login"; 
    }
}