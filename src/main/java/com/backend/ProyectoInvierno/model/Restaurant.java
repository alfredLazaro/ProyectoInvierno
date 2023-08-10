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

  private String cookingKind;

  public Restaurant() {
  }

  public int getPriceRestaurant() {
    return priceRestaurant;
  }

  public void setPriceRestaurant(int priceRestaurant) {
    this.priceRestaurant = priceRestaurant;
  }

  public int getPercentajeReservation() {
    return percentajeReservation;
  }

  public void setPercentajeReservation(int percentajeReservation) {
    this.percentajeReservation = percentajeReservation;
  }

  public Establishment getEstablishment() {
    return establishment;
  }

  public void setEstablishment(Establishment establishment) {
    this.establishment = establishment;
  }

  public String getCookingKind() {
    return cookingKind;
  }

  public void setCookingKind(String cookingKind) {
    this.cookingKind = cookingKind;
  }
}
