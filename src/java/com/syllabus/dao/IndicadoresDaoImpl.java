/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Indicadores;
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

@Repository("indicadorDao")
public class IndicadoresDaoImpl implements IndicadoresDao {
        protected final Log logger = LogFactory.getLog(IndicadoresDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveIndicadores(Indicadores indicador) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(indicador); }
            catch (Exception e) { logger.info("Mensage de Error en saveIndicadores() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Indicadores> listIndicadores() {		
		return (List<Indicadores>) sessionFactory.getCurrentSession().createCriteria(Indicadores.class).list();
	}
        public void deleteIndicadores (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Indicadores)session.get(Indicadores.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteIndicadores() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateIndicadores(Indicadores indicador){
	    try { sessionFactory.getCurrentSession().update(indicador); }
            catch (Exception e) { logger.info("Mensage de Error en updateIndicadores() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Indicadores> buscarIndicadores(Indicadores indicador){
        ArrayList<Indicadores> resultado=null;
	try {           
            resultado= (ArrayList<Indicadores>) sessionFactory.getCurrentSession().createQuery("from Indicadores p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,indicador.getDescripcion()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreIndicadores() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Indicadores> listaIndicadoresId(Indicadores indicador) {	
		return (List<Indicadores>) sessionFactory.getCurrentSession().createCriteria(Indicadores.class)
                        .add(Expression.eq("indicadorId", indicador.getIndicadoresId())).list();
	}
             
}
