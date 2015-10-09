/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Competencias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface CompetenciasService {
public ArrayList<Competencias> buscarCompetencias(Competencias competencia);
public void saveCompetencias(Competencias competencia);
public void deleteCompetencias(String id);
public List<Competencias> listaCompetenciasId(Competencias competencia);
public void updateCompetencias(Competencias competencia);



}

