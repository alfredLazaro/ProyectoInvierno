package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue("hotel")
public class Alojamiento  {

  @Id
  private long id_alojamiento;
  private int precio_alojamiento;
  private int porcentaje_reserva_alojamiento;

}
