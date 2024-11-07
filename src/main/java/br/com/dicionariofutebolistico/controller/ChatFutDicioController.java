package br.com.dicionariofutebolistico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dicionariofutebolistico.service.ChatFutDicio;

public class ChatFutDicioController {
    
    @Autowired
    private ChatFutDicio chatFutDicio;

    // Método que serve a página HTML corretamente
    @GetMapping("/chatfutdicio")
    public String showChatEsgPage() {
        return "chatfutdicio";  // Certifique-se de que o arquivo chatEsg.html está na pasta templates
    }
}

@RestController  // Use @RestController para a comunicação via AJAX
@RequestMapping("/chatEsg")
class ChatEsgRestController {

    @Autowired
    private ChatFutDicio chatFutDicio;

    // Endpoint para receber as perguntas e responder via IA
    @PostMapping("/ask")
    public String askQuestion(@RequestParam String question) {
        System.out.println("Recebendo a pergunta: " + question);  // Log para depuração
        String response = chatFutDicio.getAnswerFromAi(question);
        System.out.println("Resposta da IA: " + response);  // Log para depuração
        return response;  // Retorna a resposta da IA
    }
}


