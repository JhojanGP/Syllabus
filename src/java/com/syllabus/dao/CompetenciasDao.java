/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Competencias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface CompetenciasDao {
public void saveCompetencias(Competencias competencia);
public List<Competencias> listCompetencias();
public List<Competencias> listaCompetenciasId(Competencias competencia);
public void updateCompetencias(Competencias competencia);
public void deleteCompetencias(String id);
public ArrayList<Competencias> buscarCompetencias(Competencias competencia);
}
