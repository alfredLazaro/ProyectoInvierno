package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "establecimiento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento")
    private long idEstablecimiento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "hora_apertura")
    private Time horaApertura;

    @Column(name = "hora_cierre")
    private Time horaCierre;

    public long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Time getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }
}
