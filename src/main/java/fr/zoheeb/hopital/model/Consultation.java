package fr.zoheeb.hopital.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private Date dateConsultation;
    private String rapportConsultation;
    @OneToOne(mappedBy = "consultation")
    private RendezVous rendezVous;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return id == that.id && dateConsultation.equals(that.dateConsultation) && rapportConsultation.equals(that.rapportConsultation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateConsultation, rapportConsultation);
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", rapportConsultation='" + rapportConsultation + '\'' +
                '}';
    }
}
