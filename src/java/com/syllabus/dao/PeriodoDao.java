/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Periodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface PeriodoDao {
public void savePeriodo(Periodo periodo);
public List<Periodo> listPeriodo();
public List<Periodo> listaPeriodoId(Periodo periodo);
public void updatePeriodo(Periodo periodo);
public void deletePeriodo(String id);
public ArrayList<Periodo> buscarAgePeriodo(Periodo periodo);
}
