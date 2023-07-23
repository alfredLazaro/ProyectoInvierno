package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "alojamiento")
@PrimaryKeyJoinColumn(name = "idAlojamiento")
public class Alojamiento extends Establecimiento {

  @Column(name = "precio_alojamiento")
  private int precioAlojamiento;

  @Column(name = "porcentaje_reserva")
  private int porcentajeReserva;

  @ManyToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;

  public int getPrecioAlojamiento() {
    return precioAlojamiento;
  }

  public void setPrecioAlojamiento(int precioAlojamiento) {
    this.precioAlojamiento = precioAlojamiento;
  }

  public int getPorcentajeReserva() {
    return porcentajeReserva;
  }

  public void setPorcentajeReserva(int porcentajeReserva) {
    this.porcentajeReserva = porcentajeReserva;
  }
}
