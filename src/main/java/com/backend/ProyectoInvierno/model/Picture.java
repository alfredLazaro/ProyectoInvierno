package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "picture")
@Table(name = "picture")
public class Picture {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_picture")
  private Long id_picture;
  @Column(name = "picture_name")
  private String picture_name;
  @Column(name = "establishment_picture")
  private String establishment_picture;

  @ManyToOne
  @JoinColumn(name = "id_establishment")
  private Establishment establishment;

  public Long getId_picture() {
    return id_picture;
  }

  public void setId_picture(Long id_picture) {
    this.id_picture = id_picture;
  }

  public String getPicture_name() {
    return picture_name;
  }

  public void setPicture_name(String picture_name) {
    this.picture_name = picture_name;
  }

  public String getEstablishment_picture() {
    return establishment_picture;
  }

  public void setEstablishment_picture(String establishment_picture) {
    this.establishment_picture = establishment_picture;
  }

}
