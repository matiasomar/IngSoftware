package app;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PublicadorLocal;
import session.Usuario;

/**
 *
 * @author Administrador
 */
public class chat extends HttpServlet {

    @EJB
    private PublicadorLocal publicador;

    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("txtUser");
        String mensaje = request.getParameter("txtMensaje");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet chat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='chat' method='post'>"
                    +"<input type='text' name='txtUser'/> User <br />"
                    +"<input type='text' name='txtMensaje'/> Comentario <br/>"
                    +"<input type='submit' value='publicar' />"
                    +"</form>");
            
            boolean existe = false;
            
            ArrayList<Usuario> mensajes = publicador.obtenerPublicaciones();
            
            if(mensajes != null || !mensajes.isEmpty()){
               existe = true;
            }
            if(user.trim().equals("")|| mensaje.trim().equals("")){
                
                out.println("<p style='color: red'>Faltan datos para publicar el mensaje</p>");
            }
            else{
                out.println("<br />");
            
                publicador.agregar(user, mensaje);
            
                existe = true;
            }
            
            if(existe){
                for(int i = mensajes.size()-1; i >= 0; i--){
                    out.println("<p style='color: red'> User: "+mensajes.get(i).getUser()+"</p>");
                    out.println("<p style='font-wight: bold'> Mensaje: "+mensajes.get(i).getmensaje+"</p>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
