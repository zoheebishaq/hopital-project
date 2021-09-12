package fr.zoheeb.hopital.dao;

import fr.zoheeb.hopital.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {
}
