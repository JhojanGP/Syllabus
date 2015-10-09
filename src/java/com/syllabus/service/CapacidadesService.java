/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Capacidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface CapacidadesService {
public ArrayList<Capacidades> buscarCapacidades(Capacidades capacidad);
public void saveCapacidades(Capacidades capacidad);
public void deleteCapacidades(String id);
public List<Capacidades> listaCapacidadesId(Capacidades capacidad);
public void updateCapacidades(Capacidades capacidad);



}

