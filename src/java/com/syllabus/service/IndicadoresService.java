/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Indicadores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IndicadoresService {
public ArrayList<Indicadores> buscarIndicadores(Indicadores inidicador);
public void saveIndicadores(Indicadores inidicador);
public void deleteIndicadores(String id);
public List<Indicadores> listaIndicadoresId(Indicadores inidicador);
public void updateIndicadores(Indicadores inidicador);



}

