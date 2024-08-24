package tn.i_sante.bpo.chatbot_v1.service;

import java.util.List;

import tn.i_sante.bpo.chatbot_v1.entity.Adherent;
import tn.i_sante.bpo.chatbot_v1.entity.MaladeEnCharge;


public interface MaladeEnChargeService {

    MaladeEnCharge getMaladeEnChargeById(long id);

    MaladeEnCharge addMaladeEnCharge(MaladeEnCharge maladeEnCharge);

    void deleteMaladeEnCharge(long id);

    MaladeEnCharge updateMaladeEnCharge(MaladeEnCharge maladeEnCharge);

    List<MaladeEnCharge> getAllMaladesEnCharge();

    Adherent getAdherentByMaladeEnChargeId(long id);

    List<MaladeEnCharge> getAllMaladesEnChargeByAdherentMatricule(long matricule_adherent);


}
