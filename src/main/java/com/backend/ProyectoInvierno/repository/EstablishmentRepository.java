package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Establishment;
import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
  @Query("SELECT est FROM Establishment est ")
  List<Establishment> findAllEstablishments();
}
