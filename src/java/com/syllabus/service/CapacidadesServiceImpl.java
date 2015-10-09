package com.syllabus.service;

import com.syllabus.dao.CapacidadesDao;
import com.syllabus.modelo.Capacidades;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("capacidadService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CapacidadesServiceImpl implements CapacidadesService{
	
    
    @Autowired
    private CapacidadesDao capacidadDao;
    
    public CapacidadesServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveCapacidades(Capacidades capacidad) {         
		capacidadDao.saveCapacidades(capacidad);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCapacidades(String id) {         
		capacidadDao.deleteCapacidades(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCapacidades(Capacidades Capacidades) {         
		capacidadDao.updateCapacidades(Capacidades);
	}
        
        public List<Capacidades> listaCapacidadesId(Capacidades Capacidades) {
		return capacidadDao.listaCapacidadesId(Capacidades);
	}
        
        
        public ArrayList<Capacidades> buscarCapacidades(Capacidades capacidad) {
		return capacidadDao.buscarCapacidades(capacidad);
	} 
        
       
    
}
