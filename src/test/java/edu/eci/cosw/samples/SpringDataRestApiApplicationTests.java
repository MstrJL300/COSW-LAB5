package edu.eci.cosw.samples;


import edu.eci.cosw.samples.model.Consulta;
import edu.eci.cosw.samples.model.Paciente;
import edu.eci.cosw.samples.model.PacienteId;
import edu.eci.cosw.samples.persistance.PatientsRepository;
import edu.eci.cosw.samples.services.PatientServices;
import edu.eci.cosw.samples.services.ServicesException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDataRestApiApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class SpringDataRestApiApplicationTests {

        @Autowired
        PatientServices services;
        
        @Autowired
        PatientsRepository patientsrepository;
      
        @Test
        public void testGetPatient() throws ServicesException{
            Paciente p = new Paciente(new PacienteId(2096904, "cc"), "ramiro", new Date());
            Set<Consulta> consultas = new HashSet<>();
            consultas.add(new Consulta(new Date(), "resumen prueba"));
            p.setConsultas(consultas);
            patientsrepository.save(p);
            
            Paciente comparacion=services.getPatient(2096904, "cc");
            boolean test = p.getId().equals(comparacion.getId());
            patientsrepository.delete(patientsrepository.getOne(new PacienteId(2096904,"cc")));
            Assert.assertTrue(test);

          
          
        }
  
        @Test
        public void testPacienteInexistente() throws SecurityException{
            
            try {
                Paciente p=services.getPatient(12345678, "cc");
                Assert.fail();
            } catch (ServicesException ex) {
                Assert.assertTrue(true);
            }
                
           
            
        }
 
        @Test
        public void testTopPatients() throws ServicesException{
            Paciente p1 = new Paciente(new PacienteId(123,"cc"), "ramiro", new Date());
            Paciente p2 = new Paciente(new PacienteId(456,"cc"), "jose", new Date());
            Paciente p3 = new Paciente(new PacienteId(123456,"cc"), "Sin Consulta", new Date());
            Set<Consulta> consultas = new HashSet<>();
            consultas.add(new Consulta(new Date(),"consulta 1" ));
            p1.setConsultas(consultas);
            consultas.add(new Consulta(new Date(),"consulta 2" ));
            p2.setConsultas(consultas);
            patientsrepository.save(p1);
            patientsrepository.save(p2);
            patientsrepository.save(p3);
            
            boolean test = true;
            List<Paciente> pacientes = services.topPatients(2);
            test = test && pacientes.size()==2;
            for (Paciente paciente : pacientes) {
                test = test && (paciente.getId().equals(p1.getId()) ||paciente.getId().equals(p2.getId()));
            }
            
            
            patientsrepository.delete(patientsrepository.getOne(new PacienteId(123, "cc")));
            patientsrepository.delete(patientsrepository.getOne(new PacienteId(456, "cc")));
            patientsrepository.delete(patientsrepository.getOne(new PacienteId(123456, "cc")));
            Assert.assertTrue(test);
        }
        
  
        @Test
        public void testTopPatientsVoid() throws SecurityException, ServicesException{
            Paciente p = new Paciente(new PacienteId(2096904, "cc"), "ramiro", new Date());
            Set<Consulta> consultas = new HashSet<>();
            consultas.add(new Consulta(new Date(), "resumen prueba"));
            p.setConsultas(consultas);
            patientsrepository.save(p);
            Assert.assertEquals(0, services.topPatients(2).size());
            patientsrepository.delete(patientsrepository.getOne(new PacienteId(2096904,"cc")));
        }
        
	@Test
	public void contextLoads() {
            
	}
        
        @Test
        public void patientLoadTest(){
    
        }

}
