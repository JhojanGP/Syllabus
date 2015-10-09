/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syllabus.dao;

import com.syllabus.modelo.Trabajador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface TrabajadorDao {
public void saveTrabajador(Trabajador trabajador);
public List<Trabajador> listTrabajador();
public List<Trabajador> listaTrabajadorId(Trabajador trabajador);
public List<Trabajador> validarTrabajador(Trabajador trabajador);




public ArrayList<Trabajador> buscarNombreTrabajador(Trabajador trabajador);
public Trabajador buscarIdTrabajador(String id);
public void deleteTrabajador(String id);
public void updateTrabajador(Trabajador trabajador);

}
