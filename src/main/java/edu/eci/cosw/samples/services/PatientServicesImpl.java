/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.services;

import edu.eci.cosw.samples.model.Paciente;
import edu.eci.cosw.samples.model.PacienteId;
import edu.eci.cosw.samples.persistance.PatientsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087133
 */
@Service
public class PatientServicesImpl implements PatientServices{
    
    @Autowired 
    PatientsRepository patientsRepository;

    @Override
    public Paciente getPatient(int id, String tipoid) throws ServicesException {
        Paciente p=patientsRepository.findOne(new PacienteId(id,tipoid));
        if (p==null){
            throw new ServicesException("no existe un paciente");
        }
        return p;
    }

    @Override
    public List<Paciente> topPatients(int n) throws ServicesException {
        return patientsRepository.topPacientes(n);
    }
    
}
