/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mail.message;

/**
 *
 * @author Admin
 */
@WebServlet(name="DataOwnerConfirmation", urlPatterns={"/DataOwnerConfirmation"})
public class DataOwnerConfirmation extends HttpServlet {
   
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
            
           String hid2="rojini@avancer.com";
String mail=request.getParameter("demail");
System.out.println("aaaaaaaaaaaaaa"+mail);

String key=request.getParameter("random");
         message msg=new message();
        
String message4="Dear User,.The Access Password From the Developer used To View Services "+key;
       //msg.mail(hid2,mail, "message",message4);
          
       
         String did=request.getParameter("did");
         String status=request.getParameter("dstatus");
         String key1=request.getParameter("random");
         String Query="update dataowner_registration set D_Status='"+status+"' where D_Id='"+did+"' ";
         PreparedStatement ps=DbConnection_1.getconnection().prepareStatement(Query);
       ps.executeUpdate();
      response.sendRedirect("DataOwnerVerification.jsp");
out.println("success");
        } catch(Exception e){
        System.out.println(e);
        }  finally {
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
