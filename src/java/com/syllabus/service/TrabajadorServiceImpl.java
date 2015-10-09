/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syllabus.service;

/**
 *
 * @author Administrador
 */
import java.util.List;
import com.syllabus.dao.TrabajadorDao;
import com.syllabus.modelo.Trabajador;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("trabajadorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrabajadorServiceImpl implements TrabajadorService{
    @Autowired
    private TrabajadorDao trabajadorDao;
    
    public TrabajadorServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveTrabajador(Trabajador trabajador) {         
		trabajadorDao.saveTrabajador(trabajador);
	}
      

        public List<Trabajador> validarTrabajador(Trabajador trabajador){
        return trabajadorDao.validarTrabajador(trabajador);
        }
    
        
        
        
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTrabajador(String id) {         
		trabajadorDao.deleteTrabajador(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateTrabajador(Trabajador trabajador) {         
		trabajadorDao.updateTrabajador(trabajador);
	}
        
        public List<Trabajador> listaTrabajadorId(Trabajador trabajador ) {
		return trabajadorDao.listaTrabajadorId(trabajador);
	}
        
          public ArrayList<Trabajador> buscarNombreTrabajador(Trabajador trabajador) {
		return trabajadorDao.buscarNombreTrabajador(trabajador);
	} 
        
}
