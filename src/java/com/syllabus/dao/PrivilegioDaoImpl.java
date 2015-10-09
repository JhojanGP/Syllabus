package com.syllabus.dao;

import com.syllabus.modelo.Privilegio;
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

@Repository("privilegioDao")

public class PrivilegioDaoImpl implements PrivilegioDao {
        protected final Log logger = LogFactory.getLog(PrivilegioDaoImpl.class);  	

         @Autowired
	private SessionFactory sessionFactory;
         
         public void savePrivilegio(Privilegio privilegio) {
	    try { sessionFactory.getCurrentSession().saveOrUpdate(privilegio); }
            catch (Exception e) { logger.info("Mensage de Error en savePrivilegio() "+e.getMessage());   }
            finally{ sessionFactory.close(); }   
	}
         
        @SuppressWarnings("unchecked")
	public List<Privilegio> listPrivilegio() {		
		return (List<Privilegio>) sessionFactory.getCurrentSession().createCriteria(Privilegio.class).list();
	}
        
        public void deletePrivilegio (String id) {
            Session session=sessionFactory.openSession();
            Transaction tx = null;            
	    try { tx = session.beginTransaction();    
            session.delete((Privilegio)session.get(Privilegio.class,id));
                tx.commit(); }
            catch (Exception e) { logger.info("Mensage de Error en deletePrivilegio() "+e.getMessage());   }
            finally{  session.close();   }
            
	}
        public void updatePrivilegio(Privilegio privilegio){
	    try { sessionFactory.getCurrentSession().update(privilegio); }
            catch (Exception e) { logger.info("Mensage de Error en updateTrabajador(Trabajador trabajador) "+e.getMessage());   }
            finally{ sessionFactory.close(); }        
        }
        
        @SuppressWarnings("unchecked")        
        public List<Privilegio> listaPrivilegioId(Privilegio privilegio) {	
		return (List<Privilegio>) sessionFactory.getCurrentSession().createCriteria(Privilegio.class)
                        .add(Expression.eq("privilegioId", privilegio.getPrivilegioId())).list();
	}
        
}
