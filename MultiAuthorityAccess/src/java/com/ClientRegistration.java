/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name="ClientRegistration", urlPatterns={"/ClientRegistration"})
public class ClientRegistration extends HttpServlet {
   
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

        String client=request.getParameter("client");
             String First=request.getParameter("first");
            String Second=request.getParameter("second");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
          String country=request.getParameter("country");
           String state=request.getParameter("state");
            String city=request.getParameter("city");
            //String number=request.getParameter("mobile");
             String gender=request.getParameter("gender");
            String Query="Select * from client_registration where C_UserName ='"+username+"'";
PreparedStatement ps=DbConnection_1.getconnection().prepareStatement(Query);
ResultSet rs=ps.executeQuery();
if(!rs.next()){
    String Query2="Select * from dataowner_registration where D_UserName ='"+username+"'";
PreparedStatement ps2=DbConnection_1.getconnection().prepareStatement(Query2);
ResultSet rs2=ps2.executeQuery();

    if(!rs2.next()){

String Que="insert into client_registration(C_First,C_Second,C_UserName,C_Password,C_Email,C_Gender,C_Country,C_State,C_City,C_Status,C_Owner)values"
+ "('"+First+"','"+Second+"','"+username+"','"+password+"','"+email+"','"+gender+"','"+country+"','"+state+"','"+city+"','Not-Active','"+client+"')";
PreparedStatement is=DbConnection_1.getconnection().prepareStatement(Que);
is.executeUpdate();
response.sendRedirect("RegistrationInserted.jsp");
return ;

}response.sendRedirect("RegistrationFailed.jsp");}else{
response.sendRedirect("RegistrationFailed.jsp");
}

        }catch(Exception e){
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
