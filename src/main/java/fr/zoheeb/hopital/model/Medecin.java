package fr.zoheeb.hopital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nom;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    private Collection<RendezVous> rendezVous;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medecin medecin = (Medecin) o;
        return id == medecin.id && nom.equals(medecin.nom) && email.equals(medecin.email) && specialite.equals(medecin.specialite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, specialite);
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
