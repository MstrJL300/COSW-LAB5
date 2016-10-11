/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.jpa.sample.repository;

import edu.eci.cosw.jpa.sample.model.Paciente;
import edu.eci.cosw.jpa.sample.model.PacienteId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087133
 */

public interface PatientsRepository extends JpaRepository<Paciente, PacienteId> {
  
  @Query("SELECT p FROM PACIENTES p WHERE p.id = ?1 AND p.tipoId = ?1")
  Paciente findByPacienteID(int id, String tipoid);
  @Query("SELECT p FROM PACIENTES p WHERE SIZE(Consultas) > ?1")
  List<Paciente> findByNConsulta(int n);
}