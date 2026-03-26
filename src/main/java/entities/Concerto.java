package entities;

import enums.Genere;
import enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genere genere;

    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
