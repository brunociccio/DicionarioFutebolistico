package br.com.dicionariofutebolistico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dicionariofutebolistico.service.ChatFutDicio;

@Controller
public class ChatFutDicioController {

    @Autowired
    private ChatFutDicio chatFutDicio;

    // Método que serve a página HTML corretamente
    @GetMapping("/chatfutdicio")
    public String showChatFutDicioPage() {
        return "chatfutdicio"; 
    }
}
