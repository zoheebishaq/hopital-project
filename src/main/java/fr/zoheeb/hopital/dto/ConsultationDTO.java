package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
@Setter
public class ConsultationDTO {
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Temporal(TemporalType.TIME)
    private Date heureConsultation;
    private String rapportConsultation;
    private long RendezVousId;
}
