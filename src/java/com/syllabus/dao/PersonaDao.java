package com.syllabus.dao;

import com.syllabus.modelo.Persona;

import java.util.ArrayList;
import java.util.List;


public interface PersonaDao {
public void savePersona(Persona persona);
public List<Persona> listPersona();
public List<Persona> listaPersonaId(Persona persona);
public ArrayList<Persona> buscarNombrePersona(Persona persona);
public void deletePersona(String id);
public void updatePersona(Persona persona);


}
