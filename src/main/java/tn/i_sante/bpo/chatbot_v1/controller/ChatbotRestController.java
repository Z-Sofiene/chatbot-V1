package tn.i_sante.bpo.chatbot_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.i_sante.bpo.chatbot_v1.dto.ChatbotRequest;
import tn.i_sante.bpo.chatbot_v1.service.ChatbotService;

@RestController
@RequestMapping("/chatbot")
public class ChatbotRestController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/process")
    public String processChatbotRequest(@RequestBody ChatbotRequest chatbotRequest) {
        return chatbotService.processUserInput(chatbotRequest.getMessage());
    }
}
