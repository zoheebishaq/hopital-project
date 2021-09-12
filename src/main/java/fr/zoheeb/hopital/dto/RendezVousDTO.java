package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class RendezVousDTO {
    private long id;
    private Date dateRendezVous;
    private long medecinId;
    private long patientId;
    private long consultId;
}
