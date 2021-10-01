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
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Temporal(TemporalType.TIME)
    private Date heureConsultation;
    private String rapportConsultation;
    @OneToOne(mappedBy = "consultation")
    private RendezVous rendezVous;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return id == that.id && dateConsultation.equals(that.dateConsultation) && heureConsultation.equals(that.heureConsultation) && rapportConsultation.equals(that.rapportConsultation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateConsultation, heureConsultation, rapportConsultation);
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", heureConsultation=" + heureConsultation +
                ", rapportConsultation='" + rapportConsultation + '\'' +
                '}';
    }
}
