package org.daniel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productor")
public class Productor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int edad;
    @Column(name = "anyos_experiencia" ,nullable = false)
    private int anyosExperiencia;

    public Productor() {}

    public Productor(String nombre, int edad, int anyosExperiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.anyosExperiencia = anyosExperiencia;
    }

    public Productor(long id, String nombre, int edad, int anyosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.anyosExperiencia = anyosExperiencia;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAnyosExperiencia() {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(int anyosExperiencia) {
        this.anyosExperiencia = anyosExperiencia;
    }

    @Override
    public String toString() {
        return "Productor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", anyosExperiencia=" + anyosExperiencia +
                "}\n";
    }
}