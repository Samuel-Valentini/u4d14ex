package samuelvalentini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import samuelvalentini.enumeration.TipoEvento;

import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa", nullable = false)
    private String squadraDiCasa;
    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "numero_gol_squadra_di_casa", nullable = false)
    private short numeroGolSquadraDiCasa;
    @Column(name = "numero_gol_squadra_ospite", nullable = false)
    private short numeroGolSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, short numeroGolSquadraDiCasa, short numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
        if (numeroGolSquadraDiCasa > numeroGolSquadraOspite) {
            this.squadraVincente = squadraDiCasa;
        } else if (numeroGolSquadraOspite > numeroGolSquadraDiCasa) {
            this.squadraVincente = squadraOspite;
        } else {
            this.squadraVincente = null;
        }

    }

    protected PartitaDiCalcio() {

    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente() {
        if (this.numeroGolSquadraDiCasa > this.numeroGolSquadraOspite) {
            this.squadraVincente = this.squadraDiCasa;
        } else if (this.numeroGolSquadraOspite > this.numeroGolSquadraDiCasa) {
            this.squadraVincente = this.squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public short getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(short numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        setSquadraVincente();
    }

    public short getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(short numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
        setSquadraVincente();
    }
}
