/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import java.util.List;
import com.syllabus.modelo.Periodo;
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

@Repository("periodoDao")

public class PeriodoDaoImpl implements PeriodoDao {
        protected final Log logger = LogFactory.getLog(PeriodoDaoImpl.class);        	
       
        @Autowired
	private SessionFactory sessionFactory; 
        
        public void savePeriodo(Periodo periodo) {
	    try {
               
                
                String qry="insert into PERIODO(fiscal_age) values('"+periodo.getFiscalAge()+"') ";
        
                sessionFactory.getCurrentSession().createSQLQuery(qry).executeUpdate(); 
               }
            catch (Exception e) { logger.info("Mensage de Error en savePersona() "+e.getMessage());   }
            finally{ sessionFactory.close(); }
	}
        
        @SuppressWarnings("unchecked")
	public List<Periodo> listPeriodo() {		
		return (List<Periodo>) sessionFactory.getCurrentSession().createCriteria(Periodo.class).list();
	}
        public void deletePeriodo (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Periodo)session.get(Periodo.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deletePeriodo() "+e.getMessage());   }
            finally{  session.close();   }
	}
        public void updatePeriodo(Periodo periodo){
	    try { sessionFactory.getCurrentSession().update(periodo); }
            catch (Exception e) { logger.info("Mensage de Error en updatePeriodo() "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        @SuppressWarnings("unchecked")
	public ArrayList<Periodo> buscarAgePeriodo(Periodo periodo){
        ArrayList<Periodo> resultado=null;
	try {           
            resultado= (ArrayList<Periodo>) sessionFactory.getCurrentSession().createQuery("from Periodo p where upper(t.fiscal_age) like upper(?) order by t.fiscal_age asc ")
                    .setString(0,periodo.getFiscalAge()+"%")
                    .list();           
            }catch (Exception e) { logger.info("Mensage de Error en buscarNombrePeriodo() "+e.getMessage());   }
            finally{ sessionFactory.close(); }            
            return resultado;
	}
         @SuppressWarnings("unchecked")        
        public List<Periodo> listaPeriodoId(Periodo periodo) {	
		return (List<Periodo>) sessionFactory.getCurrentSession().createCriteria(Periodo.class)
                        .add(Expression.eq("periodoId", periodo.getPeriodoId())).list();
	}
             
}
