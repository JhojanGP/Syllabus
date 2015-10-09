package com.syllabus.dao;

import com.syllabus.modelo.Privilegio;
//import com.cticsperu.modelo.SivTrabajador;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Keima
 */
public interface PrivilegioDao {
public List<Privilegio> listPrivilegio();
public List<Privilegio> listaPrivilegioId(Privilegio privilegio);
public void savePrivilegio(Privilegio privilegio);
public void deletePrivilegio(String id);
public void updatePrivilegio(Privilegio privilegio);


    
}
