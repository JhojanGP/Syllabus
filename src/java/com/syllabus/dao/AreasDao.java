/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Areas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface AreasDao {
public void saveAreas(Areas area);
public List<Areas> listAreas();
public List<Areas> listaAreasId(Areas area);
public void updateAreas(Areas area);
public void deleteAreas(String id);
public ArrayList<Areas> buscarAreas(Areas area);
}
