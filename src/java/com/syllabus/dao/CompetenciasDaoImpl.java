/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Competencias;
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

@Repository("competenciaDao")
public class CompetenciasDaoImpl implements CompetenciasDao {
        protected final Log logger = LogFactory.getLog(CompetenciasDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveCompetencias(Competencias competencia) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(competencia); }
            catch (Exception e) { logger.info("Mensage de Error en saveCompetencias() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Competencias> listCompetencias() {		
		return (List<Competencias>) sessionFactory.getCurrentSession().createCriteria(Competencias.class).list();
	}
        public void deleteCompetencias (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Competencias)session.get(Competencias.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteCompetencias() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateCompetencias(Competencias competencia){
	    try { sessionFactory.getCurrentSession().update(competencia); }
            catch (Exception e) { logger.info("Mensage de Error en updateCompetencias() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Competencias> buscarCompetencias(Competencias competencia){
        ArrayList<Competencias> resultado=null;
	try {           
            resultado= (ArrayList<Competencias>) sessionFactory.getCurrentSession().createQuery("from Competencias p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,competencia.getDescripcion()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreCompetencias() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Competencias> listaCompetenciasId(Competencias competencias) {	
		return (List<Competencias>) sessionFactory.getCurrentSession().createCriteria(Competencias.class)
                        .add(Expression.eq("competenciasId", competencias.getCompetenciasId())).list();
	}
             
}
