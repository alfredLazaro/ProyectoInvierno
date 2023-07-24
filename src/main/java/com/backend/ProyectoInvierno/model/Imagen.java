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

  public Long getId_imagen() {
    return id_imagen;
  }

  public void setId_imagen(Long id_imagen) {
    this.id_imagen = id_imagen;
  }

  public String getNombre_imagen() {
    return nombre_imagen;
  }

  public void setNombre_imagen(String nombre_imagen) {
    this.nombre_imagen = nombre_imagen;
  }

  public String getImgenen_establecimiento() {
    return imgenen_establecimiento;
  }

  public void setImgenen_establecimiento(String imgenen_establecimiento) {
    this.imgenen_establecimiento = imgenen_establecimiento;
  }

}
