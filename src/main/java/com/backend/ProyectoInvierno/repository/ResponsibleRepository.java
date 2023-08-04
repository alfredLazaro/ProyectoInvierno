package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ResponsibleRepository extends JpaRepository<ResponsiblePerson, Long> {
  @Query("SELECT rp FROM Establishment est join est.responsiblePerson rp WHERE est.idEstablishment = :id")
  ResponsiblePerson findForId(@Param("id") Long id);
}
