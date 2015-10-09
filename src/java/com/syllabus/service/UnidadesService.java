/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Unidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface UnidadesService {
public ArrayList<Unidades> buscarUnidades(Unidades unidad);
public void saveUnidades(Unidades unidad);
public void deleteUnidades(String id);
public List<Unidades> listaUnidadesId(Unidades unidad);
public void updateUnidades(Unidades unidad);



}

