package com.backend.ProyectoInvierno.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "imagenes")
@Table(name = "imagenes")
public class Imagen {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_imagen")
  private Long id_imagen;
  @Column(name = "nombre_imagen")
  private String nombre_imagen;
  @Column(name = "imagen_establecimiento")
  private String imgenen_establecimiento;

  @ManyToOne
  @JoinColumn(name = "id_establecimiento")
  private Establecimiento establecimiento;

}
