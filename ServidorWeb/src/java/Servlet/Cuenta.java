/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataCliente;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "Cuenta", urlPatterns = {"/Cuenta/*"})
public class Cuenta extends HttpServlet {

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
        String consulta = request.getPathInfo().replace("%20"," ").substring(1);
        
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        if(consulta.equals("Conectar")){
            String nickName = port.credenciales((String) request.getParameter("Email"), (String) request.getParameter("Password"));
            if(!nickName.equals("")){
                request.getSession().setAttribute("nickName", nickName);
                request.getSession().setAttribute("Email", (String) request.getParameter("Email"));                
            }else{
                request.getSession().setAttribute("alerta", "Correo o contraseña incorrectos");                
            }
        }else if(consulta.equals("Registrar")){
            DataCliente  reg = new DataCliente();
            reg.getFav();
            reg.getNoVistas();
            reg.getPendientes();
            reg.getVisto();
            reg.setNickname( (String) request.getParameter("Nickname"));
            reg.setCorreo((String) request.getParameter("Email"));
            port.addUsr(reg, (String) request.getParameter("Password"));
        }
        
        response.sendRedirect("/Home");
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
