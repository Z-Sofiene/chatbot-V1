package tn.i_sante.bpo.chatbot_v1.service.impl;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.i_sante.bpo.chatbot_v1.service.NLPService;

import java.util.List;

@Service
public class NLPServiceImp implements NLPService {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;

    @Override
    public List<CoreMap> analyzeText(String text) {
        Annotation annotation = new Annotation(text);
        stanfordCoreNLP.annotate(annotation);
        return annotation.get(CoreAnnotations.SentencesAnnotation.class);
    }
}
