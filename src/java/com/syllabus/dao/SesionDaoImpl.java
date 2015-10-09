/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Sesion;
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

@Repository("sesionDao")
public class SesionDaoImpl implements SesionDao {
        protected final Log logger = LogFactory.getLog(SesionDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveSesion(Sesion sesion) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(sesion); }
            catch (Exception e) { logger.info("Mensage de Error en saveSesion() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Sesion> listSesion() {		
		return (List<Sesion>) sessionFactory.getCurrentSession().createCriteria(Sesion.class).list();
	}
        
        public void deleteSesion (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Sesion)session.get(Sesion.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteSesion() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateSesion(Sesion sesion){
	    try { sessionFactory.getCurrentSession().update(sesion); }
            catch (Exception e) { logger.info("Mensage de Error en updateSesion() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Sesion> buscarSesion(Sesion sesion){
        ArrayList<Sesion> resultado=null;
	try {           
            resultado= (ArrayList<Sesion>) sessionFactory.getCurrentSession().createQuery("from Sesion p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,sesion.getNombreSesion()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreSesion() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Sesion> listaSesionId(Sesion sesion) {	
		return (List<Sesion>) sessionFactory.getCurrentSession().createCriteria(Sesion.class)
                        .add(Expression.eq("sesionId", sesion.getSesionId())).list();
	}
             
}
