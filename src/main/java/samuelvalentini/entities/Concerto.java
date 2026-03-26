package samuelvalentini.entities;

import jakarta.persistence.*;
import samuelvalentini.enumeration.GenereConcerto;
import samuelvalentini.enumeration.TipoEvento;

import java.time.LocalDate;


@Entity
@Table(name = "concerti")
public class Concerto extends Evento {
    @Column(name = "genere", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenereConcerto genereConcerto;
    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genereConcerto, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    protected Concerto() {
    }

    public GenereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(GenereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
