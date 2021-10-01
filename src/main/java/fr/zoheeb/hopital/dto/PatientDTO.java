package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private long id;
    private String nom;
    private String email;
    private String numTel;

}
