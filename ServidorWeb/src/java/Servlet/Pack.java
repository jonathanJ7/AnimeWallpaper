/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import herramientas.herramienta;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DataAnimeImNom;
import servidor.DataCollection;
import servidor.DataPack;
import servidor.DataPackReducido;

/**
 *
 * @author Jonathan
 */
@WebServlet(name = "Pack", urlPatterns = {"/Pack/*"})
public class Pack extends HttpServlet {

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
            if(consulta.equals("crear")){
                Collection<DataAnimeImNom> listaAnimes = herramienta.pasarACol(port.listarAnimes());
                request.setAttribute("listaAnimes", listaAnimes);
                request.getRequestDispatcher( "/crearPack.jsp").forward(request,response);
            }else if(consulta.contains("darAltaPack")){
                String[] parametros = consulta.substring(12).split("/");
                int iter = 1;
                DataCollection dcol = new DataCollection();
                List<Object> toPack = dcol.getCol();
                while(iter<parametros.length){
                    Integer pathIm = Integer.parseInt(parametros[iter+2]);
                    toPack.add(pathIm);
                    iter += 3;                    
                }
                String cliente = (String) request.getSession().getAttribute("nickName");
                port.addPack(cliente, cliente,parametros[0], dcol);
                response.sendRedirect("/Home");
            }else if(consulta.contains("consulta")){
                String[] parametros = consulta.substring(9).split("/");
                DataPack dpack = port.detallePack(parametros[1], parametros[0]);
                request.setAttribute("detallePack", dpack);
                request.getRequestDispatcher( "/detallePack.jsp").forward(request,response);
            }
            
        }else{            
            Collection<DataPackReducido>  packCol = herramienta.pasarACol(port.listarPacks());
            request.setAttribute("colPacks", packCol);
            request.getRequestDispatcher( "/packs.jsp").forward(request,response);
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
