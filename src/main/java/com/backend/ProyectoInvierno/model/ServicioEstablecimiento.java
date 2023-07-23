package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "servicio_establecimiento")
@Entity(name = "servicio_establecimiento")
public class ServicioEstablecimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_servicio_establecimiento")
  private Long idServicioEstablecimiento;
  @Column(name = "nombre_servicio")
  private String nombreServicio;
  @Column(name = "tipo_servicio")
  private String tipoServicio;

  @ManyToOne
  @JoinColumn(name = "id_paquete")
  private PaqueteEstablecimiento paqueteEstablecimiento;


}
