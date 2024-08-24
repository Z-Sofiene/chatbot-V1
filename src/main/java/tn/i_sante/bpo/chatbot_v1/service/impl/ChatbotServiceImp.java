package tn.i_sante.bpo.chatbot_v1.service.impl;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.i_sante.bpo.chatbot_v1.service.ChatbotService;
import tn.i_sante.bpo.chatbot_v1.service.NLPService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatbotServiceImp implements ChatbotService {

    @Autowired
    private NLPService nlpService;

    public String processUserInput(String userInput) {
        List<CoreMap> sentences = nlpService.analyzeText(userInput);

        StringBuilder response = new StringBuilder("Processed input: ");
        for (CoreMap sentence : sentences) {
            String sentenceText = sentence.get(CoreAnnotations.TextAnnotation.class);
            List<String> words = sentence.get(CoreAnnotations.TokensAnnotation.class)
                .stream()
                .map(CoreLabel::originalText)
                .collect(Collectors.toList());

            response.append(String.join(" ", words)).append(". ");
        }

        return response.toString();
    }
}
