package tn.i_sante.bpo.chatbot_v1.service.impl;

import org.springframework.transaction.annotation.Transactional;
import tn.i_sante.bpo.chatbot_v1.entity.Adherent;
import tn.i_sante.bpo.chatbot_v1.repository.AdherentRepository;
import tn.i_sante.bpo.chatbot_v1.service.AdherentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdherentServiceImp implements AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;

    @Override
    public Optional<Adherent> getAdherentById(long matricule) {
        return Optional.ofNullable(adherentRepository.findById(matricule).orElse(null));
    }

    @Override
    public Adherent addAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    @Override
    public void deleteAdherentById(long matricule) {
        adherentRepository.deleteById(matricule);
    }

    @Override
    public Adherent updateAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    @Override
    public List<Adherent> getAllAdherents() {
        return adherentRepository.findAllAdherents();
    }

}
