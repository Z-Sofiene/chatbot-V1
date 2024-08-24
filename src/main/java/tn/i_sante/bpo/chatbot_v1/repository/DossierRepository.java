package tn.i_sante.bpo.chatbot_v1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.i_sante.bpo.chatbot_v1.entity.Dossier;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {
    @Query("select d from Dossier d where d.malade_en_charge.id=?1")
    List<Dossier> findAllDossiersByMaladeEnChargeId(long matricule_malade_en_charge);
}
