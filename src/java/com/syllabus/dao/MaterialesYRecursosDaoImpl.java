/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.MaterialesYRecursos;
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

@Repository("materialesYrecursosDao")
public class MaterialesYRecursosDaoImpl implements MaterialesYRecursosDao {
        protected final Log logger = LogFactory.getLog(MaterialesYRecursosDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void saveMaterialesYRecursos(MaterialesYRecursos materialesYrecursos) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(materialesYrecursos); }
            catch (Exception e) { logger.info("Mensage de Error en saveMaterialesYRecursos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
        
        @SuppressWarnings("unchecked")
	public List<MaterialesYRecursos> listMaterialesYRecursos() {		
		return (List<MaterialesYRecursos>) sessionFactory.getCurrentSession().createCriteria(MaterialesYRecursos.class).list();
	}
        public void deleteMaterialesYRecursos (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((MaterialesYRecursos)session.get(MaterialesYRecursos.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deleteMaterialesYRecursos() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updateMaterialesYRecursos(MaterialesYRecursos materialesYrecursos){
	    try { sessionFactory.getCurrentSession().update(materialesYrecursos); }
            catch (Exception e) { logger.info("Mensage de Error en updateMaterialesYRecursos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<MaterialesYRecursos> buscarMaterialesYRecursos(MaterialesYRecursos materialesYrecursos){
        ArrayList<MaterialesYRecursos> resultado=null;
	try {           
            resultado= (ArrayList<MaterialesYRecursos>) sessionFactory.getCurrentSession().createQuery("from Materiales_y_Recursos p where upper(t.descripcion) like upper(?) order by t.descripcion asc ")
                    .setString(0,materialesYrecursos.getDescripcion()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombreMaterialesYRecursos() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<MaterialesYRecursos> listaMaterialesYRecursosId(MaterialesYRecursos materialesYrecursos) {	
		return (List<MaterialesYRecursos>) sessionFactory.getCurrentSession().createCriteria(MaterialesYRecursos.class)
                        .add(Expression.eq("materialesYrecursosId", materialesYrecursos.getMaterialesYRecursosId())).list();
	}
             
}
