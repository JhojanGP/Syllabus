package com.syllabus.service;

import com.syllabus.dao.UnidadesDao;
import com.syllabus.modelo.Unidades;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("unidadService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UnidadesServiceImpl implements UnidadesService{
	
    
    @Autowired
    private UnidadesDao unidadDao;
    
    public UnidadesServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUnidades(Unidades unidad) {         
		unidadDao.saveUnidades(unidad);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUnidades(String id) {         
		unidadDao.deleteUnidades(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateUnidades(Unidades Unidades) {         
		unidadDao.updateUnidades(Unidades);
	}
        
        public List<Unidades> listaUnidadesId(Unidades Unidades) {
		return unidadDao.listaUnidadesId(Unidades);
	}
        
        
        public ArrayList<Unidades> buscarUnidades(Unidades unidad) {
		return unidadDao.buscarUnidades(unidad);
	} 
        
       
    
}
