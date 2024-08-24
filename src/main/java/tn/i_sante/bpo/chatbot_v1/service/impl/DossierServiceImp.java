package tn.i_sante.bpo.chatbot_v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.i_sante.bpo.chatbot_v1.entity.Dossier;
import tn.i_sante.bpo.chatbot_v1.entity.MaladeEnCharge;
import tn.i_sante.bpo.chatbot_v1.repository.DossierRepository;
import tn.i_sante.bpo.chatbot_v1.service.DossierService;
import tn.i_sante.bpo.chatbot_v1.service.MaladeEnChargeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DossierServiceImp implements DossierService {
    @Autowired
    private DossierRepository dossierRepository;
    @Autowired
    private MaladeEnChargeService maladeEnChargeService;

    @Override
    public List<Dossier> getAllDossiersByMaladeEnChargeId(long id_malade_en_charge) {
        return dossierRepository.findAllDossiersByMaladeEnChargeId(id_malade_en_charge);
    }

    @Override
    public Optional<Dossier> getDossierByNumConsultation(long numConsultation) {
        return Optional.ofNullable(dossierRepository.findById(numConsultation).orElse(null));
    }

    @Override
    public List<Dossier> getAllDossiersByAdherentMatricule(long matricule) {
        List<MaladeEnCharge> malades = maladeEnChargeService.getAllMaladesEnChargeByAdherentMatricule(matricule);
        List<Dossier> dossiers = new ArrayList<Dossier>();
        for (MaladeEnCharge m : malades) {
            dossiers.addAll(getAllDossiersByMaladeEnChargeId(m.getId()));
        }
        return dossiers;
    }


    @Override
    public Dossier addDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public void deleteDossierByNumConsultation(long numConsultation) {
        dossierRepository.deleteById(numConsultation);
    }

    @Override
    public Dossier updateDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }
}
