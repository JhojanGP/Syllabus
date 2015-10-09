/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Capacidades;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

@Repository("capacidadDao")
public class CapacidadesDaoImpl implements CapacidadesDao {
        protected final Log logger = LogFactory.getLog(CapacidadesDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveCapacidades(Capacidades capacidad) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(capacidad); }
            catch (Exception e) { logger.info("Mensage de Error en saveCapacidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Capacidades> listCapacidades() {		
		return (List<Capacidades>) sessionFactory.getCurrentSession().createCriteria(Capacidades.class).list();
	}
        public void deleteCapacidades (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Capacidades)session.get(Capacidades.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteCapacidades() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateCapacidades(Capacidades capacidad){
	    try { sessionFactory.getCurrentSession().update(capacidad); }
            catch (Exception e) { logger.info("Mensage de Error en updateCapacidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Capacidades> buscarCapacidades(Capacidades capacidad){
        ArrayList<Capacidades> resultado=null;
	try {           
            resultado= (ArrayList<Capacidades>) sessionFactory.getCurrentSession().createQuery("from Capacidades p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,capacidad.getDescripcion()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreCapacidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Capacidades> listaCapacidadesId(Capacidades capacidad) {	
		return (List<Capacidades>) sessionFactory.getCurrentSession().createCriteria(Capacidades.class)
                        .add(Expression.eq("capacidadId", capacidad.getCapacidadesId())).list();
	}
             
}
