package tn.i_sante.bpo.chatbot_v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tn.i_sante.bpo.chatbot_v1.entity.Adherent;
import tn.i_sante.bpo.chatbot_v1.entity.Enum.Role;
import tn.i_sante.bpo.chatbot_v1.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adherents")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @PostMapping("/add")
    public ResponseEntity<Adherent> createAdherent(MultiValueMap<String, String> formData) {
        Adherent adherent = new Adherent();

        adherent.setNom(formData.getFirst("nom"));
        adherent.setPrenom(formData.getFirst("prenom"));
        adherent.setUsername(formData.getFirst("username"));
        adherent.setPassword(formData.getFirst("password"));
        adherent.setCIN(formData.getFirst("cin"));
        adherent.setGenre(formData.getFirst("genre"));
        adherent.setRIB_RIP(formData.getFirst("rib_rip"));
        adherent.setMatricule_fiscale(formData.getFirst("fiscale"));
        adherent.setDate_de_naissance(formData.getFirst("date_de_naissance"));
        adherent.setEmail(formData.getFirst("email"));
        adherent.setRole(Role.valueOf(formData.getFirst("role")));
        return ResponseEntity.status(HttpStatus.CREATED).body(adherentService.addAdherent(adherent));
    }

    @GetMapping
    public String listAdherents(Model model) {
        List<Adherent> adherents = adherentService.getAllAdherents();
        model.addAttribute("adherents", adherents);
        return "redirect:list_adherents.html";
    }

    @PostMapping("/delete")
    public String deleteAdherent(@RequestParam("matricule") long matricule, RedirectAttributes redirectAttributes) {
        Optional<Adherent> adherent = adherentService.getAdherentById(matricule);
        if (adherent.isPresent()) {
            adherentService.deleteAdherentById(matricule);
            redirectAttributes.addFlashAttribute("message", "Contact deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Contact not found!");
        }
        return "redirect:/adherents";
    }
}
