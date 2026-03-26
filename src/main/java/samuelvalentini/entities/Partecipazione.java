package samuelvalentini.entities;


import jakarta.persistence.*;
import samuelvalentini.enumeration.StatoPartecipazione;

import java.util.UUID;

@Entity

@Table(
        name = "partecipazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_persona", "id_evento"})
        }
)


public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_partecipazione")
    private UUID idPartecipazione;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Column(name = "stato_partecipazione", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione statoPartecipazione;

    public Partecipazione(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }

    protected Partecipazione() {
    }

    public UUID getIdPartecipazione() {
        return idPartecipazione;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "idPartecipazione=" + idPartecipazione +
                ", persona=" + persona +
                ", evento=" + evento +
                ", statoPartecipazione=" + statoPartecipazione +
                '}';
    }
}
