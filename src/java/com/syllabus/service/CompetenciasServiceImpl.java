package com.syllabus.service;

import com.syllabus.dao.CompetenciasDao;
import com.syllabus.modelo.Competencias;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("competenciaService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompetenciasServiceImpl implements CompetenciasService{
	
    
    @Autowired
    private CompetenciasDao competenciaDao;
    
    public CompetenciasServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveCompetencias(Competencias competencia) {         
		competenciaDao.saveCompetencias(competencia);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteCompetencias(String id) {         
		competenciaDao.deleteCompetencias(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateCompetencias(Competencias Competencias) {         
		competenciaDao.updateCompetencias(Competencias);
	}
        
        public List<Competencias> listaCompetenciasId(Competencias Competencias) {
		return competenciaDao.listaCompetenciasId(Competencias);
	}
        
        
        public ArrayList<Competencias> buscarCompetencias(Competencias competencia) {
		return competenciaDao.buscarCompetencias(competencia);
	} 
        
       
    
}
