/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Sesion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface SesionService {
public ArrayList<Sesion> buscarSesion(Sesion sesion);
public void saveSesion(Sesion sesion);
public void deleteSesion(String id);
public List<Sesion> listaSesionId(Sesion sesion);
public void updateSesion(Sesion sesion);



}

