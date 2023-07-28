package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "establishment")
@Inheritance(strategy = InheritanceType.JOINED)
public class Establishment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_establishment")
  private long idEstablishment;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "opening_time")
  private Time openingTime;

  @Column(name = "closing_time")
  private Time closing_time;

  @OneToOne(mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
  private Location location;

  @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Picture> pictures;

  @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EstablishmentPackage> establishmentPackages;

  @ManyToOne
  @JoinColumn(name = "id_resposible")
  private ResponsiblePerson responsiblePerson;

  public Long getIdResponsible() {
    return responsiblePerson.getId();
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Location getLocation() {
    return this.location;
  }

  public long getIdEstablishment() {
    return idEstablishment;
  }

  public void setIdEstablishment(long idEstablishment) {
    this.idEstablishment = idEstablishment;
  }


  public void setDescription(String description) {
    this.description = description;
  }

  public Time getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(Time openingTime) {
    this.openingTime = openingTime;
  }

  public Time getClosing_time() {
    return closing_time;
  }

  public void setClosing_time(Time closing_time) {
    this.closing_time = closing_time;
  }

  public List<Picture> getPictures() {
    return pictures;
  }

  public void setPictures(List<Picture> pictures) {
    this.pictures = pictures;
  }

  public List<EstablishmentPackage> getEstablishmentPackages() {
    return establishmentPackages;
  }

  public void setEstablishmentPackages(List<EstablishmentPackage> establishmentPackages) {
    this.establishmentPackages = establishmentPackages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescripton(String description) {
    this.description = description;
  }

}
