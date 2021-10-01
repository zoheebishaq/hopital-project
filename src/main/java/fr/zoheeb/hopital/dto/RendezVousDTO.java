package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
@Setter
public class RendezVousDTO {
    private long id;
    @Temporal(TemporalType.DATE)
    private Date dateRendezVous;
    @Temporal(TemporalType.TIME)
    private Date heureRendezVous;
    private long medecinId;
    private long patientId;
    private long consultationId;
}
