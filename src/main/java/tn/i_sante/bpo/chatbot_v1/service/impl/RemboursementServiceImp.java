package tn.i_sante.bpo.chatbot_v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.i_sante.bpo.chatbot_v1.entity.Remboursement;
import tn.i_sante.bpo.chatbot_v1.repository.RemboursementRepository;
import tn.i_sante.bpo.chatbot_v1.service.RemboursementService;

import java.util.List;

@Service
@Transactional
public class RemboursementServiceImp implements RemboursementService {
    @Autowired
    private RemboursementRepository remboursementRepository;
    @Override
    public Remboursement addRemboursement(Remboursement remboursement) {
        return remboursementRepository.save(remboursement);
    }

    @Override
    public Remboursement updateRemboursement(Remboursement remboursement) {
        return remboursementRepository.save(remboursement);
    }

    @Override
    public Remboursement getRemboursementById(long id_remboursement) {
        return remboursementRepository.findById(id_remboursement).orElse(null);
    }

    @Override
    public Remboursement getRemboursementByTiersPayantId(long num_transaction) {
        return remboursementRepository.findByTiersPayantId(num_transaction);
    }

    @Override
    public List<Remboursement> getAllRemboursements() {
        return remboursementRepository.findAll();
    }

    @Override
    public List<Remboursement> getAllRemboursementsByDossierId(long num_consultation) {
        return remboursementRepository.findAllByDossierID(num_consultation);
    }

    @Override
    public void deleteRemboursementById(long id_remboursement) {
        remboursementRepository.deleteById(id_remboursement);
    }
}
