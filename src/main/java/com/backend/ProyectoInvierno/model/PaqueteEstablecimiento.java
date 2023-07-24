package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "paquete_establecimiento")
@Table(name = "paquete_establecimiento")
@Inheritance(strategy = InheritanceType.JOINED)
public class PaqueteEstablecimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_paquete")
  private Long idPaquete;

  @ManyToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;
  @OneToMany(mappedBy = "paqueteEstablecimiento", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ServicioEstablecimiento> servicioEstablecimientos;


  public Long getIdPaquete() {
    return idPaquete;
  }

  public void setIdPaquete(Long idPaquete) {
    this.idPaquete = idPaquete;
  }


  public List<ServicioEstablecimiento> getServicioEstablecimientos() {
    return servicioEstablecimientos;
  }

  public void setServicioEstablecimientos(List<ServicioEstablecimiento> servicioEstablecimientos) {
    this.servicioEstablecimientos = servicioEstablecimientos;
  }
}
