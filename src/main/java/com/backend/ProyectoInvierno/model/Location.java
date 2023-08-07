package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "location")
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_location")
  private long id_location;
  @Column(name = "latitude_location")
  private String latitude_location;
  @Column(name = "longitude_location")
  private String longitude_location;
  @Column(name = "nombre_ubicacion")
  private String location_name;

  public long getId_location() {
    return id_location;
  }

  public void setId_location(long id_location) {
    this.id_location = id_location;
  }

  public String getLatitude_location() {
    return latitude_location;
  }

  public void setLatitude_location(String latitude_location) {
    this.latitude_location = latitude_location;
  }

  public String getLongitude_location() {
    return longitude_location;
  }

  public void setLongitude_location(String longitude_location) {
    this.longitude_location = longitude_location;
  }

  public String getLocation_name() {
    return location_name;
  }

  public void setLocation_name(String location_name) {
    this.location_name = location_name;
  }

  @OneToOne
  @JoinColumn(name = "id_establishment")
  private Establishment establishment;

}
