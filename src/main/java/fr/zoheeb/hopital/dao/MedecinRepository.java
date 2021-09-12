package fr.zoheeb.hopital.dao;

import fr.zoheeb.hopital.model.Medecin;
import org.springframework.data.repository.CrudRepository;

public interface MedecinRepository extends CrudRepository<Medecin,Long> {
}
