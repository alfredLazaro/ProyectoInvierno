package com.backend.ProyectoInvierno.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "responsiblePerson")
public class ResponsiblePerson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_responsible")
  private long id;

  @OneToMany
  @JoinColumn(name = "id_establishment", referencedColumnName = "id_responsible")
  private List<Establishment> establishments;

  @Column(name = "reponsible_name")
  private String name;
  @Column(name = "responsible_phone")
  private String responsible_phone;
  @Column(name = "responsible_date_registration")
  private Date dateRegistration;
  @Column(name = "languages_responsible")
  private String languagesResponsible;
  @Column(name = "email_responsible")
  private String emailResponsible;
  @Column(name = "password_responsible")
  private String passwordResponsible;
  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Establishment> getEstablishments() {
    return establishments;
  }

  public void setEstablishments(List<Establishment> establishments) {
    this.establishments = establishments;
  }


  public String getResponsible_phone() {
    return responsible_phone;
  }

  public void setResponsible_phone(String responsible_phone) {
    this.responsible_phone = responsible_phone;
  }

  public Date getDateRegistration() {
    return dateRegistration;
  }

  public void setDateRegistration(Date dateRegistration) {
    this.dateRegistration = dateRegistration;
  }

  public String getLanguagesResponsible() {
    return languagesResponsible;
  }

  public void setLanguagesResponsible(String languagesResponsible) {
    this.languagesResponsible = languagesResponsible;
  }

  public String getEmailResponsible() {
    return emailResponsible;
  }

  public void setEmailResponsible(String emailResponsible) {
    this.emailResponsible = emailResponsible;
  }

  public String getPasswordResponsible() {
    return passwordResponsible;
  }

  public void setPasswordResponsible(String passwordResponsible) {
    this.passwordResponsible = passwordResponsible;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
