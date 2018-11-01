/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name="UploadData", urlPatterns={"/UploadData"})
public class UploadData extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

             String First=request.getParameter("dname");
            String dno=request.getParameter("dno");
            String random=request.getParameter("random");
            String email=request.getParameter("demail");
          String country=request.getParameter("dcon");
int ran= new Random().nextInt(123456);
         String Random=String.valueOf(ran);

          String UpView="insert into viewfile (T_ViewID,T_ViewName,T_ViewEmail,T_ViewCountry,T_ViewRandomNo)"
+ "values('"+dno+"','"+First+"','"+email+"','"+country+"','"+random+"')";
            PreparedStatement ps=DbConnection_1.getconnection().prepareStatement(UpView);
            int i=ps.executeUpdate();
            
            String UpEdit="insert into editfile (T_EditID,T_EditName,T_EditEmail,T_EditCountry,T_EditRandomNo)"
+ "values('"+dno+"','"+First+"','"+email+"','"+country+"','"+Random+"')";
         PreparedStatement pss=DbConnection_1.getconnection().prepareStatement(UpEdit);
         int j=pss.executeUpdate();
        
        request.setAttribute("Ran",Random);
         RequestDispatcher dispatcher= getServletConfig().getServletContext().getRequestDispatcher("/UploadFiles.jsp");
         dispatcher.forward(request, response);

            
        }catch(Exception e){

        System.out.println(e);
        }
         finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
