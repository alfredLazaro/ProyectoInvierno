package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurant")
@PrimaryKeyJoinColumn(name = "id_Restaurant")
public class Restaurant extends Establishment {

  @Column(name = "price_restaurant")
  private int priceRestaurant;
  @Column(name = "reservation_percentage_restaurante")
  private int percentajeReservation;

  @ManyToOne
  @JoinColumn(name = "id_establishment")
  private Establishment establishment;

}
