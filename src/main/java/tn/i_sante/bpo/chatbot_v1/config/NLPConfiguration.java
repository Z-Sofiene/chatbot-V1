package tn.i_sante.bpo.chatbot_v1.config;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class NLPConfiguration {

    private static Properties properties;
    private static final String propertiesName = "tokenize, ssplit, pos, lemma, ner";

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    @Bean
    public StanfordCoreNLP stanfordCoreNLP() {
        return new StanfordCoreNLP(properties);
    }
}
