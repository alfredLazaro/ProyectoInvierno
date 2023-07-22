package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

@Entity//(name = "establecimiento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Establecimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id_establecimiento;
  private String nombre_establecimiento;
  private String descripcion_establecimiento;
  private String hora_apertura;
  private String hora_cierre;

  @OneToOne
  private Ubicacion ubicacion_establecimiento;

}
