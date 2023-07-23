package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
@PrimaryKeyJoinColumn(name = "idRestaurante")
public class Restaurante extends Establecimiento {

  @Column(name = "precio_restaurante")
  private int precio_restaurante;
  @Column(name = "porcentaje_reserva_restaurante")
  private int porcentaje_reserva_restaurante;

  @ManyToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;


}
