/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Areas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface AreasService {
public ArrayList<Areas> buscarAreas(Areas area);
public void saveAreas(Areas area);
public void deleteAreas(String id);
public List<Areas> listaAreasId(Areas area);
public void updateAreas(Areas area);



}

