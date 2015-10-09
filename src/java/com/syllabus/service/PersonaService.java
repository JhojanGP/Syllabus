/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface PersonaService {
public ArrayList<Persona> buscarNombrePersona(Persona persona);
public void savePersona(Persona persona);
public void deletePersona(String id);
public List<Persona> listaPersonaId(Persona Persona);
public void updatePersona(Persona Persona);



}

