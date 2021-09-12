package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ConsultationDTO {
    private long id;
    private Date dateConsultation;
    private String rapportConsultation;
    private long RendezVousId;
}
