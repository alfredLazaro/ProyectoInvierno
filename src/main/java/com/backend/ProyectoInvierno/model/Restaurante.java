package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("restaurante")
public class Restaurante{
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id_restaurante;
  private int precio_restaurante;
  private int porcentaje_reserva_restaurante;

}
