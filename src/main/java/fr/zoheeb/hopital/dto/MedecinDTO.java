package fr.zoheeb.hopital.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedecinDTO {
    private long id;
    private String nom;
    private String email;
    private String specialite;
}
