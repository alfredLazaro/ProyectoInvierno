package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;


@Table(name = "establishment_service")
@Entity(name = "establishment_service")
public class EstablishmentService {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_establishment_service")
  private Long idEstablishmentService;
  @Column(name = "service_name")
  private String serviceName;
  @Column(name = "type_service")
  private String typeService;

  @ManyToOne
  @JoinColumn(name = "id_package")
  private EstablishmentPackage establishmentPackage;

  public Long getIdEstablishmentService() {
    return idEstablishmentService;
  }

  public void setIdEstablishmentService(Long idEstablishmentService) {
    this.idEstablishmentService = idEstablishmentService;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getTypeService() {
    return typeService;
  }

  public void setTypeService(String typeService) {
    this.typeService = typeService;
  }

}