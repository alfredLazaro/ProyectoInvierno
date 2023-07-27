package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accommodation")
@PrimaryKeyJoinColumn(name = "id_accommodation")
public class Accommodation extends Establishment {

  @Column(name = "price_accommodation")
  private int price_accommodation;

  @Column(name = "reservation_percentage")
  private int reservationPercentage;

  @ManyToOne
  @JoinColumn(name = "id_establishment")
  private Establishment establishment;

  public int getPrice_accommodation() {
    return price_accommodation;
  }

  public void setPrice_accommodation(int price_accommodation) {
    this.price_accommodation = price_accommodation;
  }

  public int getReservationPercentage() {
    return reservationPercentage;
  }

  public void setReservationPercentage(int reservationPercentage) {
    this.reservationPercentage = reservationPercentage;
  }

  public Establishment getEstablishment() {
    return establishment;
  }

  public void setEstablishment(Establishment establishment) {
    this.establishment = establishment;
  }
}
