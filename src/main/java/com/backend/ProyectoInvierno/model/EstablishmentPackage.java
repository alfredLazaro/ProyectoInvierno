package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "establishment_package")
@Table(name = "establishment_package")
@Inheritance(strategy = InheritanceType.JOINED)
public class EstablishmentPackage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_package")
  private Long idPackage;

  @ManyToOne
  @JoinColumn(name = "id_establishment")
  private Establishment establishment;
  @OneToMany(mappedBy = "establishmentPackage", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EstablishmentService> establishmentServices;


  public Long getIdPackage() {
    return idPackage;
  }

  public void setIdPackage(Long idPackage) {
    this.idPackage = idPackage;
  }


  public List<EstablishmentService> getEstablishmentServices() {
    return establishmentServices;
  }

  public void setEstablishmentServices(List<EstablishmentService> establishmentServices) {
    this.establishmentServices = establishmentServices;
  }
}
