package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;


@Table(name = "establichment_service")
@Entity(name = "establichment_service")
public class EstablishmentService {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_establichment_service")
  private Long idEstablichmentService;
  @Column(name = "service_name")
  private String serviceName;
  @Column(name = "tipo_servicio")
  private String tipoServicio;

  @ManyToOne
  @JoinColumn(name = "id_package")
  private EstablishmentPackage establishmentPackage;

  public Long getIdEstablichmentService() {
    return idEstablichmentService;
  }

  public void setIdEstablichmentService(Long idEstablichmentService) {
    this.idEstablichmentService = idEstablichmentService;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getTipoServicio() {
    return tipoServicio;
  }

  public void setTipoServicio(String tipoServicio) {
    this.tipoServicio = tipoServicio;
  }

}