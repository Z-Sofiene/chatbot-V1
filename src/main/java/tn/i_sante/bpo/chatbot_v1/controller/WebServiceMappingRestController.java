package tn.i_sante.bpo.chatbot_v1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.i_sante.bpo.chatbot_v1.service.WebServiceMapping;

import java.util.List;

@RestController
@RequestMapping("/webservices")
public class WebServiceMappingRestController {

    @Autowired
    private WebServiceMapping webserviceMapping;

    @GetMapping
    public List<String> webServiceMapping() {
        return webserviceMapping.WebServices();
    }
}
