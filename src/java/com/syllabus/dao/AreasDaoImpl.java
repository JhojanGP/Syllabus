/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Areas;
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

@Repository("areaDao")
public class AreasDaoImpl implements AreasDao {
        protected final Log logger = LogFactory.getLog(AreasDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveAreas(Areas area) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(area); }
            catch (Exception e) { logger.info("Mensage de Error en saveAreas() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<Areas> listAreas() {		
		return (List<Areas>) sessionFactory.getCurrentSession().createCriteria(Areas.class).list();
	}
        public void deleteAreas (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Areas)session.get(Areas.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteAreas() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateAreas(Areas area){
	    try { sessionFactory.getCurrentSession().update(area); }
            catch (Exception e) { logger.info("Mensage de Error en updateAreas() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Areas> buscarAreas(Areas area){
        ArrayList<Areas> resultado=null;
	try {           
            resultado= (ArrayList<Areas>) sessionFactory.getCurrentSession().createQuery("from Areas p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,area.getAreaNombre()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreAreas() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
        
         @SuppressWarnings("unchecked")        
        public List<Areas> listaAreasId(Areas area) {	
		return (List<Areas>) sessionFactory.getCurrentSession().createCriteria(Areas.class)
                        .add(Expression.eq("trabajadorId", area.getAreasId())).list();
	}
             
}
