/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.services;

import edu.eci.cosw.jpa.sample.model.Paciente;
import edu.eci.cosw.jpa.sample.model.PacienteId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 2087133
 */

public interface PatientsRepository extends JpaRepository<Paciente, PacienteId> {
  
//    @Query("select p from Paciente p where p.id = ?1 and p.tipoid = ?2")       
//    @Query(value="SELECT * FROM PACIENTES p WHERE id = ?1 AND tipo_id = ?2", nativeQuery = true)
//    @Query(value="SELECT * FROM PACIENTES p WHERE id = ?1 AND tipo_id = ?2", nativeQuery = true)
//    Paciente findByPacienteID(int id, String tipoid);

    @Query("select p from Paciente p where size(p.consultas) >= ?1")
    List<Paciente> findByNConsulta(int n);
}
