package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
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


}
