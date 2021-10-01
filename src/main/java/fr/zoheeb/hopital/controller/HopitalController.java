package fr.zoheeb.hopital.controller;

import fr.zoheeb.hopital.dto.MedecinDTO;
import fr.zoheeb.hopital.dto.PatientDTO;
import fr.zoheeb.hopital.dto.RendezVousDTO;
import fr.zoheeb.hopital.model.Medecin;
import fr.zoheeb.hopital.model.Patient;
import fr.zoheeb.hopital.service.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HopitalController {

    private HopitalService hopitalService;

    @Autowired
    public HopitalController(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    //Medecin-----------------------------------------------------------------------------------------------------------

    @GetMapping("/medecin")
    public String getMedecins(Model model) {
        model.addAttribute("medecinList", hopitalService.getMedecins());
        return "medecinList";
    }

    @PostMapping("/medecin")
    public String postMedecin(@ModelAttribute(name = "medecin") MedecinDTO medecinDTO) {
        hopitalService.saveMedecins(medecinDTO);
        return "redirect:/medecin";
    }

    @GetMapping("medecin/form")
    public String addMedecin(Model model) {
        model.addAttribute("medecinForm",new MedecinDTO());
        return "medecinForm";
    }

    @GetMapping("/medecin/{id}")
    public String getMedecin(Model model, @PathVariable(name = "id") Long id) {
        Medecin medecin = hopitalService.getMedecin(id);
        MedecinDTO medecinDTO = new MedecinDTO();
        medecinDTO.setId(medecin.getId());
        medecinDTO.setNom(medecin.getNom());
        medecinDTO.setEmail(medecin.getEmail());
        medecinDTO.setSpecialite(medecin.getSpecialite());
        model.addAttribute("medecinForm", medecinDTO);
        return "medecinForm";
    }

    @GetMapping("/medecin/delete/{id}")
    public String deleteMedecin(Model model, @PathVariable(name ="id") Long id) {
        hopitalService.deleteMedecins(id);
        return "redirect:/medecin";
    }

    //Patient-----------------------------------------------------------------------------------------------------------

    @GetMapping("/patient")
    public String getPatients(Model model) {
        model.addAttribute("patientList", hopitalService.getPatients());
        return "patientList";
    }

    @PostMapping("/patient")
    public String postPatient(@ModelAttribute(name = "patient") PatientDTO patientDTO) {
        hopitalService.savePatients(patientDTO);
        return "redirect:/patient";
    }

    @GetMapping("patient/form")
    public String addPatient(Model model) {
        model.addAttribute("patientForm",new PatientDTO());
        return "patientForm";
    }

    @GetMapping("/patient/{id}")
    public String getPatient(Model model, @PathVariable(name = "id") Long id) {
        Patient patient = hopitalService.getPatient(id);
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setNom(patient.getNom());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setNumTel(patient.getNumTel());

        model.addAttribute("patientForm", patientDTO);
        return "patientForm";
    }


    @GetMapping("/patient/delete/{id}")
    public String deletePatient(Model model, @PathVariable(name ="id") Long id) {
        hopitalService.deletePatients(id);
        return "redirect:/patient";
    }

    //RendezVous--------------------------------------------------------------------------------------------------------

    @GetMapping("/rendezVous")
    public String getRdvs(Model model) {
        model.addAttribute("rdvList", hopitalService.getRendezVousList());
        return "rdvList";
    }

    @PostMapping("/rendezVous")
    public String postRdv(@ModelAttribute(name = "rendezVous") RendezVousDTO rendezVousDTO) {
        hopitalService.saveRendezVous(rendezVousDTO);
        return "redirect:/rendezVous";
    }



}
