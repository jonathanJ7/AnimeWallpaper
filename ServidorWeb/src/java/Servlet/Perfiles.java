/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import herramientas.herramienta;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataCliente;
import servidor.DataPackReducido;
import servidor.DataUsuario;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "Perfiles", urlPatterns = {"/Perfiles/*"})
public class Perfiles extends HttpServlet {

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
        String consulta = request.getPathInfo();
        
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        if(consulta != null){
            consulta = consulta.replace("%20"," ").substring(1);
            DataCliente dcli = port.detalleCliente(consulta);
            request.setAttribute("detalleCliente", dcli);//optimizar
            request.getRequestDispatcher( "/detalleCliente.jsp").forward(request,response);
        }else{
            Collection<String> col = herramienta.pasarACol(port.listarUsuarios());  
            request.setAttribute("colUsr", col);
            request.getRequestDispatcher( "/usuarios.jsp").forward(request,response);
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
