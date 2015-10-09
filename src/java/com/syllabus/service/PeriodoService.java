/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Periodo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface PeriodoService {
public ArrayList<Periodo> buscarAgePeriodo(Periodo periodo);
public void savePeriodo(Periodo periodo);
public void deletePeriodo(String id);
public List<Periodo> listaPeriodoId(Periodo periodo);
public void updatePeriodo(Periodo periodo);



}

