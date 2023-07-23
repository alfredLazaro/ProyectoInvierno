package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_ubicacion")
  private long id_ubicacion;
  private String latitud_ubicacion;
  private String longuityd_ubicacion;
  private String nombre_ubicacion;

  @OneToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;

}
