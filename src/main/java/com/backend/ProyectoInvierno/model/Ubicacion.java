package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_ubicacion")
  private long id_ubicacion;
  @Column(name = "latitud_ubicacion")
  private String latitud_ubicacion;
  @Column(name = "longuitud_ubicacion")
  private String longuitud_ubicacion;
  @Column(name = "nombre_ubicacion")
  private String nombre_ubicacion;

  public long getId_ubicacion() {
    return id_ubicacion;
  }

  public void setId_ubicacion(long id_ubicacion) {
    this.id_ubicacion = id_ubicacion;
  }

  public String getLatitud_ubicacion() {
    return latitud_ubicacion;
  }

  public void setLatitud_ubicacion(String latitud_ubicacion) {
    this.latitud_ubicacion = latitud_ubicacion;
  }

  public String getLonguitud_ubicacion() {
    return longuitud_ubicacion;
  }

  public void setLonguitud_ubicacion(String longuitud_ubicacion) {
    this.longuitud_ubicacion = longuitud_ubicacion;
  }

  public String getNombre_ubicacion() {
    return nombre_ubicacion;
  }

  public void setNombre_ubicacion(String nombre_ubicacion) {
    this.nombre_ubicacion = nombre_ubicacion;
  }

  @OneToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;

}
