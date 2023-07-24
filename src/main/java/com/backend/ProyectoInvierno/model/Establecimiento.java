package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "establecimiento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Establecimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_establecimiento")
  private long idEstablecimiento;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "hora_apertura")
  private Time horaApertura;

  @Column(name = "hora_cierre")
  private Time horaCierre;

  @OneToOne(mappedBy = "establecimiento", cascade = CascadeType.ALL, orphanRemoval = true)
  private Ubicacion ubicacion;

  @OneToMany(mappedBy = "establecimiento", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Imagen> imagenes;

  @OneToMany(mappedBy = "establecimiento", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PaqueteEstablecimiento> paqueteEstablecimientos;

  @ManyToOne
  @JoinColumn(name = "id_encargado")
  private Encargado encargado;

  public void setUbicacion(Ubicacion ubicacion) {
    this.ubicacion = ubicacion;
  }

  public Ubicacion getUbicacion() {
    return this.ubicacion;
  }

  public long getIdEstablecimiento() {
    return idEstablecimiento;
  }

  public void setIdEstablecimiento(long idEstablecimiento) {
    this.idEstablecimiento = idEstablecimiento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Time getHoraApertura() {
    return horaApertura;
  }

  public void setHoraApertura(Time horaApertura) {
    this.horaApertura = horaApertura;
  }

  public Time getHoraCierre() {
    return horaCierre;
  }

  public void setHoraCierre(Time horaCierre) {
    this.horaCierre = horaCierre;
  }

  public List<Imagen> getImagenes() {
    return imagenes;
  }

  public void setImagenes(List<Imagen> imagenes) {
    this.imagenes = imagenes;
  }

  public List<PaqueteEstablecimiento> getPaqueteEstablecimientos() {
    return paqueteEstablecimientos;
  }

  public void setPaqueteEstablecimientos(List<PaqueteEstablecimiento> paqueteEstablecimientos) {
    this.paqueteEstablecimientos = paqueteEstablecimientos;
  }

}
