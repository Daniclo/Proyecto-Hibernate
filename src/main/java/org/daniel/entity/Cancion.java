package org.daniel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private double duracion;
    @Column(nullable = false)
    private String genero;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Cancion() {}

    public Cancion(String nombre, double duracion, String genero, Album album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.album = album;
    }

    public Cancion(long id, String nombre, double duracion, String genero, Album album) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                ", album=" + album.getNombre() +
                "}\n";
    }
}