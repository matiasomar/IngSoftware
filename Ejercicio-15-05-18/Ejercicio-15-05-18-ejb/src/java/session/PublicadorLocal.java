/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface PublicadorLocal {

    ArrayList<Usuario> agregar(String user, String mensaje);

    ArrayList<Usuario> obtenerPublicaciones();
    
}
