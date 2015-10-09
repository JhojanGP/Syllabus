/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.MaterialesYRecursos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface MaterialesYRecursosService {
public ArrayList<MaterialesYRecursos> buscarMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);
public void saveMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);
public void deleteMaterialesYRecursos(String id);
public List<MaterialesYRecursos> listaMaterialesYRecursosId(MaterialesYRecursos materialesYrecursos);
public void updateMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);



}

