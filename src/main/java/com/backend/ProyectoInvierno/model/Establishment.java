package com.backend.ProyectoInvierno.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_resposible")
  @JsonProperty(access = Access.WRITE_ONLY) // Ignorar propiedad LAZY (no se serealice).
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

  public String getDescription() {
    return description;
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

  public ResponsiblePerson getResponsiblePerson() {
    return responsiblePerson;
  }

  public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
    this.responsiblePerson = responsiblePerson;
  }
}
