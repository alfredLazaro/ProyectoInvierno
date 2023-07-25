package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "encargado")
public class Encargado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_encargado")
  private long id;

  @OneToMany
  @JoinColumn(name = "id_establecimiento", referencedColumnName = "id_encargado")
  private List<Establecimiento> establecimientos;

  @Column(name = "nombre_encargado")
  private String nombre;
  @Column(name = "telefono_encargado")
  private String telefono;
  @Column(name = "fecha_registro_encargado")
  private Date fechaRegistro;
  @Column(name = "idiomas_encargado")
  private String idiomas;
  @Column(name = "correo_encargado")
  private String correo;
  @Column(name = "contrasena_encargado")
  private String contrasenia;
  @Column(name = "fecha_nacimiento_encargado")
  private Date fechaNacimiento;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Establecimiento> getEstablecimientos() {
    return establecimientos;
  }

  public void setEstablecimientos(List<Establecimiento> establecimientos) {
    this.establecimientos = establecimientos;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Date getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(Date fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public String getIdiomas() {
    return idiomas;
  }

  public void setIdiomas(String idiomas) {
    this.idiomas = idiomas;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getContrasenia() {
    return contrasenia;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
}
