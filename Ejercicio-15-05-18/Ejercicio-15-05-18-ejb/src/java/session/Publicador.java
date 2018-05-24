/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.ArrayList;
import javax.ejb.Singleton;

/**
 *
 * @author Administrador
 */
@Singleton
public class Publicador implements PublicadorLocal {

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    ArrayList<Usuario> publicaciones = new ArrayList<>();

    @Override
    public ArrayList<Usuario> agregar(String user, String mensaje) {
        publicaciones.add(new Usuario(user,mensaje));
        return publicaciones;
    }

    @Override
    public ArrayList obtenerPublicaciones() {
        return publicaciones;
    }

   
    
    
    
    
}
