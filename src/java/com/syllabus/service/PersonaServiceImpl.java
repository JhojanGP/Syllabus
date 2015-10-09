package com.syllabus.service;

import com.syllabus.dao.PersonaDao;
import com.syllabus.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("personaService")

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonaServiceImpl implements PersonaService{
	
    
    @Autowired
    private PersonaDao personaDao;
    
    public PersonaServiceImpl(){}
    
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void savePersona(Persona persona) {         
		personaDao.savePersona(persona);
	}
	
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deletePersona(String id) {         
		personaDao.deletePersona(id);
	}
        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePersona(Persona Persona) {         
		personaDao.updatePersona(Persona);
	}
        
        public List<Persona> listaPersonaId(Persona Persona) {
		return personaDao.listaPersonaId(Persona);
	}
        
        
        public ArrayList<Persona> buscarNombrePersona(Persona persona) {
		return personaDao.buscarNombrePersona(persona);
	} 
        
       
    
}
