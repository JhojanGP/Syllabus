/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Unidades;
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

@Repository("unidadDao")
public class UnidadesDaoImpl implements UnidadesDao {
        protected final Log logger = LogFactory.getLog(UnidadesDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveUnidades(Unidades unidad) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(unidad); }
            catch (Exception e) { logger.info("Mensage de Error en saveUnidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Unidades> listUnidades() {		
		return (List<Unidades>) sessionFactory.getCurrentSession().createCriteria(Unidades.class).list();
	}
        public void deleteUnidades (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Unidades)session.get(Unidades.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteUnidades() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateUnidades(Unidades unidad){
	    try { sessionFactory.getCurrentSession().update(unidad); }
            catch (Exception e) { logger.info("Mensage de Error en updateUnidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Unidades> buscarUnidades(Unidades unidad){
        ArrayList<Unidades> resultado=null;
	try {           
            resultado= (ArrayList<Unidades>) sessionFactory.getCurrentSession().createQuery("from Unidades p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,unidad.getUnidadNombre()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreUnidades() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Unidades> listaUnidadesId(Unidades unidades) {	
		return (List<Unidades>) sessionFactory.getCurrentSession().createCriteria(Unidades.class)
                        .add(Expression.eq("unidadesId", unidades.getUnidadesId())).list();
	}
             
}
