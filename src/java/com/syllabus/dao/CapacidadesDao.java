/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.Capacidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface CapacidadesDao {
public void saveCapacidades(Capacidades capacidad);
public List<Capacidades> listCapacidades();
public List<Capacidades> listaCapacidadesId(Capacidades capacidad);
public void updateCapacidades(Capacidades capacidad);
public void deleteCapacidades(String id);
public ArrayList<Capacidades> buscarCapacidades(Capacidades capacidad);
}
