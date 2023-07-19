package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
