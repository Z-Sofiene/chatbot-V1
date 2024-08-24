package tn.i_sante.bpo.chatbot_v1.service;

import edu.stanford.nlp.util.CoreMap;

import java.util.List;

public interface NLPService {
    List<CoreMap> analyzeText(String text);
}
