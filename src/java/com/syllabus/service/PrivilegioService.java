/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.service;


import com.syllabus.modelo.Privilegio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface PrivilegioService {
public void savePrivilegio(Privilegio privilegio);
public void deletePrivilegio(String id);
public List<Privilegio> listaPrivilegioId(Privilegio privilegio);
public void updatePrivilegio(Privilegio privilegio);

}

