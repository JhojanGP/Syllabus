/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Sesion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface SesionDao {
public void saveSesion(Sesion sesion);
public List<Sesion> listSesion();
public List<Sesion> listaSesionId(Sesion sesion);
public void updateSesion(Sesion sesion);
public void deleteSesion(String id);
public ArrayList<Sesion> buscarSesion(Sesion sesion);
}
