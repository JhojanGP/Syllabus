package com.syllabus.service;

import com.syllabus.dao.AreasDao;
import com.syllabus.modelo.Areas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("areasService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AreasServiceImpl implements AreasService{
	
    
    @Autowired
    private AreasDao areasDao;
    
    public AreasServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveAreas(Areas areas) {         
		areasDao.saveAreas(areas);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAreas(String id) {         
		areasDao.deleteAreas(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAreas(Areas Areas) {         
		areasDao.updateAreas(Areas);
	}
        
        public List<Areas> listaAreasId(Areas Areas) {
		return areasDao.listaAreasId(Areas);
	}
        
        
        public ArrayList<Areas> buscarAreas(Areas areas) {
		return areasDao.buscarAreas(areas);
	} 
        
       
    
}
