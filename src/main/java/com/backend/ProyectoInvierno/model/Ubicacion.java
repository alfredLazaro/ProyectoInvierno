package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id_ubicacion;
  private String latitud_ubicacion;
  private String longuityd_ubicacion;
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

  public String getLonguityd_ubicacion() {
    return longuityd_ubicacion;
  }

  public void setLonguityd_ubicacion(String longuityd_ubicacion) {
    this.longuityd_ubicacion = longuityd_ubicacion;
  }

  public String getNombre_ubicacion() {
    return nombre_ubicacion;
  }

  public void setNombre_ubicacion(String nombre_ubicacion) {
    this.nombre_ubicacion = nombre_ubicacion;
  }
}
