package fr.zoheeb.hopital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Patient {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && nom.equals(patient.nom) && email.equals(patient.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
