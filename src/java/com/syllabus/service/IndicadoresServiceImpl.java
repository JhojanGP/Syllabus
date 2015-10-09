package com.syllabus.service;

import com.syllabus.dao.IndicadoresDao;
import com.syllabus.modelo.Indicadores;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("indicadorService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IndicadoresServiceImpl implements IndicadoresService{
	
    
    @Autowired
    private IndicadoresDao indicadorDao;
    
    public IndicadoresServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveIndicadores(Indicadores indicador) {         
		indicadorDao.saveIndicadores(indicador);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteIndicadores(String id) {         
		indicadorDao.deleteIndicadores(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateIndicadores(Indicadores Indicadores) {         
		indicadorDao.updateIndicadores(Indicadores);
	}
        
        public List<Indicadores> listaIndicadoresId(Indicadores Indicadores) {
		return indicadorDao.listaIndicadoresId(Indicadores);
	}
        
        
        public ArrayList<Indicadores> buscarIndicadores(Indicadores indicador) {
		return indicadorDao.buscarIndicadores(indicador);
	} 
        
       
    
}
