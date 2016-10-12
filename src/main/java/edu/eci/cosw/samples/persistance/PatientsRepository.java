/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.persistance;

import edu.eci.cosw.samples.model.Paciente;
import edu.eci.cosw.samples.model.PacienteId;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2087133
 */

public interface PatientsRepository extends JpaRepository<Paciente, PacienteId>{
        @Query("from Paciente p where size(p.consultas)>= :top")
        List<Paciente> topPacientes(@Param(value = "top")int top1);
        
        
}
