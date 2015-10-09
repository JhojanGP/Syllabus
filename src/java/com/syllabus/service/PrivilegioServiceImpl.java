package com.syllabus.service;

import com.syllabus.dao.PrivilegioDao;
import com.syllabus.modelo.Privilegio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("privilegioService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PrivilegioServiceImpl implements PrivilegioService{
	
    
    @Autowired
    private PrivilegioDao privilegioDao;
    
    public PrivilegioServiceImpl(){}
    
    
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePrivilegio(Privilegio privilegio) {         
		privilegioDao.savePrivilegio(privilegio);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePrivilegio(String id) {         
		privilegioDao.deletePrivilegio(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePrivilegio(Privilegio Privilegio) {         
		privilegioDao.updatePrivilegio(Privilegio);
	}
        
        public List<Privilegio> listaPrivilegioId(Privilegio Privilegio) {
		return privilegioDao.listaPrivilegioId(Privilegio);
	}
    
    
}
