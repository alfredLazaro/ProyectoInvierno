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

  @Column(name = "cooking_kind")
  private String cookingKind;

  public int getPriceRestaurant() {
    return priceRestaurant;
  }

  public void setPriceRestaurant(int priceRestaurant) {
    this.priceRestaurant = priceRestaurant;
  }

  public String getCookingKind() {
    return cookingKind;
  }

  public void setCookingKind(String cookingKind) {
    this.cookingKind = cookingKind;
  }
}
