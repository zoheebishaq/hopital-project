package fr.zoheeb.hopital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class RendezVous {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private Date dateRendezVous;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Consultation consultation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVous that = (RendezVous) o;
        return id == that.id && dateRendezVous.equals(that.dateRendezVous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateRendezVous);
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "id=" + id +
                ", dateRendezVous=" + dateRendezVous +
                '}';
    }
}
