package br.com.dicionariofutebolistico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dicionariofutebolistico.service.ChatFutDicio;

@RestController
@RequestMapping("/chatfutdicio")
public class ChatFutDicioRestController {

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
