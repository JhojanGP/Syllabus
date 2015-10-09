/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.dao;

import com.syllabus.modelo.MaterialesYRecursos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keima
 */
public interface MaterialesYRecursosDao {
public void saveMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);
public List<MaterialesYRecursos> listMaterialesYRecursos();
public List<MaterialesYRecursos> listaMaterialesYRecursosId(MaterialesYRecursos area);
public void updateMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);
public void deleteMaterialesYRecursos(String id);
public ArrayList<MaterialesYRecursos> buscarMaterialesYRecursos(MaterialesYRecursos materialesYrecursos);
}
