/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataAnime;
import servidor.DataCalidad;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "ajax", urlPatterns = {"/ajax/*"})
public class ajax extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            String consulta = request.getPathInfo().replace("%20"," ").substring(1);
            String[] parametros = consulta.split("/");
            String usuario = (String) request.getSession().getAttribute("nickName");
            DataAnime danime = port.detalleAnime(parametros[1]);
            for(DataAnime.Calidades.Entry ent : danime.getCalidades().getEntry()){
                for(DataCalidad.Imgs.Entry entIm: ent.getValue().getImgs().getEntry()){
                    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(entIm.getValue().getImag());
                    String path = parametros[1]+"/"+ent.getKey()+"/"+ Integer.toString(entIm.getKey());
                    out.println("<img class=\"image\"  alt=\""+path+"\" onclick=\"seleccionar(this)\" src=\"data:image/png;base64, "+b64+"\" >");
                }
            }
        }finally {
            out.close();
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
