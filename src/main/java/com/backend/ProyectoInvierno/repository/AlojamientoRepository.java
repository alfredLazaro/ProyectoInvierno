package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {
//  @Query("Select * from alojamiento where id_establecimiento=1")
//  List<Alojamiento> obtenerTodos();
}
