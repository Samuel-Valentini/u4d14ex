package samuelvalentini.entities;

import jakarta.persistence.*;
import samuelvalentini.enumeration.TipoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "eventi")

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_evento")
    private UUID idEvento;
    @Column(name = "nome_evento", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione_evento", nullable = false)
    private String descrizione;
    @Column(name = "tipo_evento", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_max_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;
    @Column(name = "ora_inizio", nullable = true)
    private LocalTime oraInizio;
    @Column(name = "ora_fine_prevista", nullable = true)
    private LocalTime oraFinePrevista;

    @ManyToOne
    @JoinColumn(name = "id_location", nullable = true)
    private Location location;

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        if (numeroMassimoPartecipanti < 0) {
            throw new IllegalArgumentException("il numero massimo dei partecipanti deve essere positivo");
        }
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        if (numeroMassimoPartecipanti < 0) {
            throw new IllegalArgumentException("il numero massimo dei partecipanti deve essere positivo");
        }
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, LocalTime oraInizio, LocalTime oraFinePrevista) {
        if (numeroMassimoPartecipanti < 0) {
            throw new IllegalArgumentException("il numero massimo dei partecipanti deve essere positivo");
        }
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.oraInizio = oraInizio;
        this.oraFinePrevista = oraFinePrevista;
        this.location = location;
    }

    protected Evento() {
    }

    public UUID getId() {
        return idEvento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        if (numeroMassimoPartecipanti < 0) {
            throw new IllegalArgumentException("il numero massimo dei partecipanti deve essere positivo");
        }
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public LocalTime getOraFinePrevista() {
        return oraFinePrevista;
    }

    public void setOraFinePrevista(LocalTime oraFinePrevista) {
        this.oraFinePrevista = oraFinePrevista;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", oraInizio=" + oraInizio +
                ", oraFinePrevista=" + oraFinePrevista +
                ", location=" + location +
                '}';
    }
}
