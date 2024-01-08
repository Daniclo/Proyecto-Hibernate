package org.daniel.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "anyo_creacion",nullable = false)
    private Date anyoCreacion;

    public Grupo() {}

    public Grupo(String nombre, Date anyoCreacion) {
        this.nombre = nombre;
        this.anyoCreacion = anyoCreacion;
    }

    public Grupo(long id, String nombre, Date anyoCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.anyoCreacion = anyoCreacion;
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

    public Date getAnyoCreacion() {
        return anyoCreacion;
    }

    public void setAnyoCreacion(Date anyoCreacion) {
        this.anyoCreacion = anyoCreacion;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anyoCreacion=" + anyoCreacion +
                "}\n";
    }
}