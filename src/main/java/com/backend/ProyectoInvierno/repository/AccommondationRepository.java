package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommondationRepository extends JpaRepository<Accommodation, Long> {
//  @Query("Select * from alojamiento where id_establecimiento=1")
//  List<Alojamiento> obtenerTodos();
}
