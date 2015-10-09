package com.syllabus.dao;

import com.syllabus.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("personaDao")
public class PersonaDaoImpl implements PersonaDao {
        protected final Log logger = LogFactory.getLog(PersonaDaoImpl.class);  	

         @Autowired
	private SessionFactory sessionFactory;                 
        
        
       
	public void savePersona(Persona persona) {
	    try {
               
                
                String qry="insert into PERSONA(NOMBRES, APELL_PATERN, APELL_MATER, DNI, DIRECCION, ESTADO_CIVIL, GENERO, E_MAIL) values('"+persona.getNombres()+"','"+persona.getApellPatern()+"','"+persona.getApellMater()+"','"+persona.getDni()+"','"+persona.getDireccion()+"','"+persona.getEstadoCivil()+"','"+persona.getGenero()+"','"+persona.getEMail()+"','"+persona.getCelular()+"') ";
        
                sessionFactory.getCurrentSession().createSQLQuery(qry).executeUpdate(); 
               }
            catch (Exception e) { logger.info("Mensage de Error en savePersona() "+e.getMessage());   }
            finally{ sessionFactory.close(); }
	}
        
        public void deletePersona (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Persona)session.get(Persona.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deletePersona() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updatePersona(Persona Persona){
	    try { sessionFactory.getCurrentSession().update(Persona); }
            catch (Exception e) { logger.info("Mensage de Error en updatePersona(Persona Persona) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        @SuppressWarnings("unchecked")        
        public List<Persona> listaPersonaId(Persona Persona) {	
		return (List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class)
                        .add(Expression.eq("personaId", Persona.getPersonaId())).list();
	}
        
	@SuppressWarnings("unchecked")
	public List<Persona> listPersona() {		
		return (List<Persona>) sessionFactory.getCurrentSession().createCriteria(Persona.class).list();
	}
   
	
        @SuppressWarnings("unchecked")
	public ArrayList<Persona> buscarNombrePersona(Persona persona){
        ArrayList<Persona> resultado=null;
	try {           
            resultado= (ArrayList<Persona>) sessionFactory.getCurrentSession().createQuery("from Persona aa where upper(aa.nombres) like upper(?) order by aa.nombres asc, aa.dni asc ")
                    .setString(0,persona.getNombres()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombrePersona() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}   
        
        

   



}
