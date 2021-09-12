package fr.zoheeb.hopital.service;
import com.google.common.collect.Lists;
import fr.zoheeb.hopital.dao.ConsultationRepository;
import fr.zoheeb.hopital.dao.MedecinRepository;
import fr.zoheeb.hopital.dao.PatientRepository;
import fr.zoheeb.hopital.dao.RendezVousRepository;
import fr.zoheeb.hopital.dto.MedecinDTO;
import fr.zoheeb.hopital.dto.PatientDTO;
import fr.zoheeb.hopital.model.Medecin;
import fr.zoheeb.hopital.model.Patient;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HopitalService {
    ConsultationRepository consultationRepository;
    MedecinRepository medecinRepository;
    PatientRepository patientRepository;
    RendezVousRepository rendezVousRepository;

    public HopitalService(ConsultationRepository consultationRepository,
                          MedecinRepository medecinRepository,
                          PatientRepository patientRepository,
                          RendezVousRepository rendezVousRepository) {
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
        this.rendezVousRepository = rendezVousRepository;
    }


    //Patient-------------------------------------------------------------------------
    public List<Patient> getPatients(){
        return Lists.newArrayList(patientRepository.findAll());
    }
    public Patient getPatient(Long id){
        return patientRepository.findById(id).orElse(new Patient());
    }

    public void deletePatients(Long id){
        patientRepository.deleteById(id);
    }
    public void savePatients(PatientDTO patientDTO)
    {
        Patient patientDB = patientRepository.findById(patientDTO.getId()).orElse(new Patient());
        patientDB.setNom(patientDTO.getNom());
        patientDB.setEmail(patientDB.getEmail());
        patientRepository.save(patientDB);
    }

    //Medecin----------------------------------------------------------------------------

    public List<Medecin> getMedecins(){
        return Lists.newArrayList(medecinRepository.findAll());
    }
    public Medecin getMedecin(Long id){
        return medecinRepository.findById(id).orElse(new Medecin());
    }

    public void deleteMedecins(Long id){
        medecinRepository.deleteById(id);
    }
    public void saveMedecins(MedecinDTO medecinDTO)
    {
        Medecin medecinDB = medecinRepository.findById(medecinDTO.getId()).orElse(new Medecin());
        medecinDB.setNom(medecinDTO.getNom());
        medecinDB.setEmail(medecinDTO.getEmail());
        medecinDB.setSpecialite(medecinDTO.getEmail());
        medecinRepository.save(medecinDB);
    }

    //Rendez-vous---------------------------------------------------------------------------
    
}
