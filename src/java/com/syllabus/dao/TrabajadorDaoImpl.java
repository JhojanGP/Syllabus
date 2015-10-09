/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syllabus.dao;

/**
 *
 * @author Administrador
 */
import java.util.List;
import com.syllabus.modelo.Trabajador;
import java.util.ArrayList;
//import java.util.Iterator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;


@Repository("trabajadorDao")
public class TrabajadorDaoImpl implements TrabajadorDao {
        protected final Log logger = LogFactory.getLog(TrabajadorDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory;                 
        
        

	public void saveTrabajador(Trabajador trabajador) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(trabajador); }
            catch (Exception e) { logger.info("Mensage de Error en saveTrabajador() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
	@SuppressWarnings("unchecked")
	public List<Trabajador> listTrabajador() {		
		return (List<Trabajador>) sessionFactory.getCurrentSession().createCriteria(Trabajador.class).list();
	}
        
       
        
        
	@SuppressWarnings("unchecked")
	public List<Trabajador> validarTrabajador(Trabajador trabajador) {
        List<Trabajador> resultado=null;   String usuario=trabajador.getUsuario(); String pasword=trabajador.getPassword();
	try {           
           resultado= (List<Trabajador>) sessionFactory.getCurrentSession().createCriteria(Trabajador.class)
                                                 .add(Expression.eq("usuario", usuario) )
                                                 .add(Expression.eq("passwd", pasword)).list();                      
          
            }catch (Exception e) { logger.info("Mensage de Error en validarTrabajador() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        
         public void deleteTrabajador (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Trabajador)session.get(Trabajador.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteTrabajador() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateTrabajador(Trabajador trabajador){
	    try { sessionFactory.getCurrentSession().update(trabajador); }
            catch (Exception e) { logger.info("Mensage de Error en updateTrabajador(Trabajador trabajador) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        @SuppressWarnings("unchecked")        
        public List<Trabajador> listaTrabajadorId(Trabajador trabajador) {	
		return (List<Trabajador>) sessionFactory.getCurrentSession().createCriteria(Trabajador.class)
                        .add(Expression.eq("trabajadorId", trabajador.getTrabajadorId())).list();
	}
             
      
        @SuppressWarnings("unchecked")
	public ArrayList<Trabajador> buscarNombreTrabajador(Trabajador trabajador){
        ArrayList<Trabajador> resultado=null;
	try {           
            resultado= (ArrayList<Trabajador>) sessionFactory.getCurrentSession().createQuery("from Trabajador t where upper(t.usuario) like upper(?) order by t.usuario asc ")
                    .setString(0,trabajador.getUsuario()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreTrabajador() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
       @SuppressWarnings("unchecked")
	public Trabajador buscarIdTrabajador(String id){
        Trabajador resultado=null;
	try {           
            resultado= (Trabajador) sessionFactory.getCurrentSession().createQuery("from Trabajador t where upper(t.trabajador_id) like upper(?) order by t.trabajador_id asc ")
                    .setString(0, id)
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarIdTrabajador() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
        
        
        
 }
        
        
  

