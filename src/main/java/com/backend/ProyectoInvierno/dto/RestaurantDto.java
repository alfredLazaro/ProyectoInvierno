package com.backend.ProyectoInvierno.dto;

import java.sql.Time;

public class RestaurantDto {
  private String restaurantName;
  private String description;
  private String latitude;
  private String longitude;
  private Time openingTime;
  private Time closingTime;
  private String pictureName;
  private String establishmentPicture;

  public RestaurantDto() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Time getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(Time openingTime) {
    this.openingTime = openingTime;
  }

  public Time getClosingTime() {
    return closingTime;
  }

  public void setClosingTime(Time closingTime) {
    this.closingTime = closingTime;
  }

  public String getPictureName() {
    return pictureName;
  }

  public void setPictureName(String pictureName) {
    this.pictureName = pictureName;
  }

  public String getEstablishmentPicture() {
    return establishmentPicture;
  }

  public void setEstablishmentPicture(String establishmentPicture) {
    this.establishmentPicture = establishmentPicture;
  }
}
