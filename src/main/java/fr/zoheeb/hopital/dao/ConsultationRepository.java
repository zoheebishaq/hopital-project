package fr.zoheeb.hopital.dao;

import fr.zoheeb.hopital.model.Consultation;
import org.springframework.data.repository.CrudRepository;

public interface ConsultationRepository extends CrudRepository<Consultation,Long> {
}
