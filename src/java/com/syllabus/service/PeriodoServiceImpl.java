package com.syllabus.service;

import com.syllabus.dao.PeriodoDao;
import com.syllabus.modelo.Periodo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("periodoService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PeriodoServiceImpl implements PeriodoService{
	
    
    @Autowired
    private PeriodoDao periodoDao;
    
    public PeriodoServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePeriodo(Periodo periodo) {         
		periodoDao.savePeriodo(periodo);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePeriodo(String id) {         
		periodoDao.deletePeriodo(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePeriodo(Periodo Periodo) {         
		periodoDao.updatePeriodo(Periodo);
	}
        
        public List<Periodo> listaPeriodoId(Periodo Periodo) {
		return periodoDao.listaPeriodoId(Periodo);
	}
        
        
        public ArrayList<Periodo> buscarAgePeriodo(Periodo periodo) {
		return periodoDao.buscarAgePeriodo(periodo);
	} 
        
       
    
}
