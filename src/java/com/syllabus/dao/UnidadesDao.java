/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syllabus.dao;

import com.syllabus.modelo.Unidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface UnidadesDao {
public void saveUnidades(Unidades Unidad);
public List<Unidades> listUnidades();
public List<Unidades> listaUnidadesId(Unidades Unidad);
public ArrayList<Unidades> buscarUnidades(Unidades Unidad);
public void deleteUnidades(String id);
public void updateUnidades(Unidades Unidad);

}
