package org.daniel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo_has_artista")
public class GrupoHasArtista {
    @Id
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Id
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
    @Column(name = "sigue_en_el_grupo",nullable = false)
    private boolean sigueEnElGrupo;

    public GrupoHasArtista() {}


    public GrupoHasArtista(Grupo grupo, Artista artista, boolean sigueEnElGrupo) {
        this.grupo = grupo;
        this.artista = artista;
        this.sigueEnElGrupo = sigueEnElGrupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public boolean isSigueEnElGrupo() {
        return sigueEnElGrupo;
    }

    public void setSigueEnElGrupo(boolean sigueEnElGrupo) {
        this.sigueEnElGrupo = sigueEnElGrupo;
    }

    @Override
    public String toString() {
        return "ArtistaHasGrupo{" +
                "grupo=" + grupo.getNombre() +
                ", artista=" + artista.getNombre() +
                ", sigueEnElGrupo=" + sigueEnElGrupo +
                "}\n";
    }
}