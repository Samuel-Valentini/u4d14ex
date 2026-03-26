package samuelvalentini.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_location")
    private UUID idLocation;
    @Column(name = "nome_location", nullable = false)
    private String nomeLocation;
    @Column(name = "citta_location", nullable = false)
    private String cittaLocation;

    public Location(String nomeLocation, String cittaLocation) {
        this.nomeLocation = nomeLocation;
        this.cittaLocation = cittaLocation;
    }

    protected Location() {
    }

    public UUID getIdLocation() {
        return idLocation;
    }

    public String getNomeLocation() {
        return nomeLocation;
    }

    public void setNomeLocation(String nomeLocation) {
        this.nomeLocation = nomeLocation;
    }

    public String getCittaLocation() {
        return cittaLocation;
    }

    public void setCittaLocation(String cittaLocation) {
        this.cittaLocation = cittaLocation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", nomeLocation='" + nomeLocation + '\'' +
                ", città='" + cittaLocation + '\'' +
                '}';
    }
}
