/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syllabus.service;

import com.syllabus.modelo.Trabajador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface TrabajadorService {
public List<Trabajador> validarTrabajador(Trabajador trabajador);
public void saveTrabajador(Trabajador trabajador);
public ArrayList<Trabajador> buscarNombreTrabajador(Trabajador trabajador);
public void deleteTrabajador(String id);
public List<Trabajador> listaTrabajadorId(Trabajador trabajador);
public void updateTrabajador(Trabajador trabajador);

}
