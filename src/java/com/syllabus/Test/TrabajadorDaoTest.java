package com.syllabus.test;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
 
import java.util.List;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

 
import com.syllabus.modelo.Trabajador;
import com.syllabus.dao.TrabajadorDao;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

 
 
@RunWith(SpringJUnit4ClassRunner.class)
public class TrabajadorDaoTest {
    
    final Logger logger = LoggerFactory.getLogger(TrabajadorDaoTest.class);
  
 @Autowired
  private TrabajadorDao trabajadordao;
 
    private Trabajador createObjeto(String trabId, String perId, String areId,
            String user, String passw, String cargo, Date fecha) 
  {
   
        Trabajador trabajador=new Trabajador();
        trabajador.setTrabajadorId(trabId);
        trabajador.setPersonaId(perId);
        trabajador.setAreasId(areId);
        trabajador.setUsuario(user);
        trabajador.setPassword(passw);
        trabajador.setCargo(cargo);
        trabajador.setFechaAcceso(fecha);
   
        
        try {
        trabajadordao.saveTrabajador(trabajador);
        ///System.out.println("id grabado " + obj.getId());
        } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
   
  return trabajador;
  }
    
    public void testSave() {
   logger.info("Probando Metodo Save");
    
   String trabId = "5";
   String perId = "5";
   String areId = "15.000";
   String user = "zero";
   String passw ="123";
   String cargo ="ADMIN";
   Date date=Date.from(Instant.EPOCH);
                
    
   //Creo el objeto en base a la informacion proporcionada
   Trabajador trabajador = createObjeto(trabId, perId, areId, user, passw,
           cargo, date);
   System.out.println("Paso");
    
   Trabajador trabajadorsearch = null;
   try {
    System.out.println("Identificador" + trabajador.getTrabajadorId());
    //busco el objeto en base al identificador
   trabajadorsearch = trabajadordao.buscarIdTrabajador(trabajador.getTrabajadorId());
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
   System.out.println("Identificador" + trabajadorsearch.getTrabajadorId().toString());
   //realizo el control de la salida de buscqueda con los datos cargados
   assertNotNull("AccountEntity is null.", trabajador);   
   assertEquals("Numero", trabId,trabajadorsearch.getTrabajadorId());
   assertEquals("Nombre", perId,trabajadorsearch.getPersonaId());
   assertEquals("Balance", areId,trabajadorsearch.getAreasId());
   assertEquals("Estado", user,trabajadorsearch.getUsuario());
   assertEquals("Estado", passw,trabajadorsearch.getPassword());
   assertEquals("Estado", cargo,trabajadorsearch.getCargo());
   assertEquals("Estado", date,trabajadorsearch.getFechaAcceso());
    
    }
    /*
    @Test
    public void testSaveTrabajador()
    {
        Trabajador trabajador = new Trabajador();
        trabajador.setTrabajadorId("5");
        trabajador.setPersonaId("5");
        trabajador.setAreasId("5");
        trabajador.setUsuario("zero");
        trabajador.setPassword("123");
        Date date=new Date();
        trabajador.setFechaAcceso(date);

        trabajadordao.saveTrabajador(trabajador);
        String id = trabajador.getTrabajadorId();
        Assert.assertNotNull(id);

        Assert.assertEquals(2, trabajadordao.buscarIdTrabajador(id).size());
        Trabajador newTrabajador = trabajadordao.buscarNombreTrabajador(id);

        Assert.assertEquals("Jane Doe", newMember.getName());
        Assert.assertEquals("jane.doe@mailinator.com", newMember.getEmail());
        Assert.assertEquals("2125552121", newMember.getPhoneNumber());
        return;
    }
    */
    
    
}
