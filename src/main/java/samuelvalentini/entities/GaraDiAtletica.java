package samuelvalentini.entities;

import jakarta.persistence.*;
import samuelvalentini.enumeration.TipoEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {
    @ManyToOne
    @JoinColumn(name = "id_vincitore")
    private Persona vincitore;

    @ManyToMany
    @JoinTable(
            name = "gare_di_atletica_atleti",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_persona"))
    private List<Persona> atleti = new ArrayList<>();

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.vincitore = vincitore;
    }

    protected GaraDiAtletica() {
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> persone) {
        this.atleti = persone;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "vincitore=" + vincitore +
                ", atleti=" + atleti +
                "} " + super.toString();
    }
}
