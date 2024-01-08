package org.daniel.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "num_canciones",nullable = false)
    private int numCanciones;
    @Column(nullable = false)
    private int anyo;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    @OneToOne
    @JoinColumn(name = "productor_id")
    private Productor productor;

    public Album() {}

    public Album(String nombre, int numCanciones, int anyo, Artista artista, Productor productor) {
        this.nombre = nombre;
        this.numCanciones = numCanciones;
        this.anyo = anyo;
        this.artista = artista;
        this.productor = productor;
    }

    public Album(String nombre, int numCanciones, int anyo, Grupo grupo, Productor productor) {
        this.nombre = nombre;
        this.numCanciones = numCanciones;
        this.anyo = anyo;
        this.grupo = grupo;
        this.productor = productor;
    }

    public Album(long id, String nombre, int numCanciones, int anyo, Artista artista, Grupo grupo, Productor productor) {
        this.id = id;
        this.nombre = nombre;
        this.numCanciones = numCanciones;
        this.anyo = anyo;
        this.artista = artista;
        this.grupo = grupo;
        this.productor = productor;
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

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    @Override
    public String toString() {
        if (artista != null){
            return "Album{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", numCanciones=" + numCanciones +
                    ", anyo=" + anyo +
                    ", artista=" + artista.getNombre() +
                    ", productor=" + productor.getNombre() +
                    "}\n";
        }else if (grupo != null){
            return "Album{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", numCanciones=" + numCanciones +
                    ", anyo=" + anyo +
                    ", grupo=" + grupo.getNombre() +
                    ", productor=" + productor.getNombre() +
                    "}\n";
        }else return "Album{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numCanciones=" + numCanciones +
                ", anyo=" + anyo +
                ", productor=" + productor.getNombre() +
                "}\n";
    }
}