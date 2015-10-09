/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Indicadores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface IndicadoresDao {
public void saveIndicadores(Indicadores inidicador);
public List<Indicadores> listIndicadores();
public List<Indicadores> listaIndicadoresId(Indicadores indicador);
public void updateIndicadores(Indicadores inidicador);
public void deleteIndicadores(String id);
public ArrayList<Indicadores> buscarIndicadores(Indicadores inidicador);
}
