package com.syllabus.service;

import com.syllabus.dao.MaterialesYRecursosDao;
import com.syllabus.modelo.MaterialesYRecursos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("materialesYrecursosService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MaterialesYRecursosServiceImpl implements MaterialesYRecursosService{
	
    
    @Autowired
    private MaterialesYRecursosDao materialesYrecursosDao;
    
    public MaterialesYRecursosServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveMaterialesYRecursos(MaterialesYRecursos materialesYrecursos) {         
		materialesYrecursosDao.saveMaterialesYRecursos(materialesYrecursos);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteMaterialesYRecursos(String id) {         
		materialesYrecursosDao.deleteMaterialesYRecursos(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateMaterialesYRecursos(MaterialesYRecursos materialesYrecursos) {         
		materialesYrecursosDao.updateMaterialesYRecursos(materialesYrecursos);
	}
        
        public List<MaterialesYRecursos> listaMaterialesYRecursosId(MaterialesYRecursos materialesYrecursos) {
		return materialesYrecursosDao.listaMaterialesYRecursosId(materialesYrecursos);
	}
        
        
        public ArrayList<MaterialesYRecursos> buscarMaterialesYRecursos(MaterialesYRecursos materialesYrecursos) {
		return materialesYrecursosDao.buscarMaterialesYRecursos(materialesYrecursos);
	} 
        
       
    
}
