package org.daniel.dto;

public class GrupoHasArtistasDTO {
    private String nombreGrupo;
    private String nombreArtista;
    private boolean sigueEnElGrupo;
    public GrupoHasArtistasDTO() {}
    public GrupoHasArtistasDTO(String nombreGrupo, String nombreArtista, boolean sigueEnElGrupo) {
        this.nombreGrupo = nombreGrupo;
        this.nombreArtista = nombreArtista;
        this.sigueEnElGrupo = sigueEnElGrupo;
    }
    public String getNombreGrupo() {
        return nombreGrupo;
    }
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    public String getNombreArtista() {
        return nombreArtista;
    }
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }
    public boolean isEnElGrupo() {
        return sigueEnElGrupo;
    }
    public void setSigueEnElGrupo(boolean sigueEnElGrupo) {
        this.sigueEnElGrupo = sigueEnElGrupo;
    }
    @Override
    public String toString() {
        return "GrupoHasArtistasDTO{" +
                "nombreGrupo='" + nombreGrupo + '\'' +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", sigueEnElGrupo=" + sigueEnElGrupo +
                "}\n";
    }
}