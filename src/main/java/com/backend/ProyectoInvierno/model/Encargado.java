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
}
