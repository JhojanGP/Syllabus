package com.syllabus.service;

import com.syllabus.dao.SesionDao;
import com.syllabus.modelo.Sesion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sesionService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SesionServiceImpl implements SesionService{
	
    
    @Autowired
    private SesionDao sesionDao;
    
    public SesionServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveSesion(Sesion sesion) {         
		sesionDao.saveSesion(sesion);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSesion(String id) {         
		sesionDao.deleteSesion(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateSesion(Sesion Sesion) {         
		sesionDao.updateSesion(Sesion);
	}
        
        public List<Sesion> listaSesionId(Sesion Sesion) {
		return sesionDao.listaSesionId(Sesion);
	}
        
        
        public ArrayList<Sesion> buscarSesion(Sesion sesion) {
		return sesionDao.buscarSesion(sesion);
	} 
        
       
    
}
