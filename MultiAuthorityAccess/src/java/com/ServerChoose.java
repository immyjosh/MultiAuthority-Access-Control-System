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
@WebServlet(name="ServerChoose", urlPatterns={"/ServerChoose"})
public class ServerChoose extends HttpServlet {
   
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

             String id=request.getParameter("dno");
             String first=request.getParameter("first");
             String server=request.getParameter("server");
             String cost=request.getParameter("cost");
             //System.out.println(cost);
            System.out.println("sssssssssserver"+server);
             if(server.equals("nill")){
              response.sendRedirect("ChooseServerError.jsp");
              return;
             }

            String ww="select * from server where S_Uid='"+id+"'";
             PreparedStatement ps =DbConnection_1.getconnection().prepareStatement(ww);
             ResultSet rs=ps.executeQuery();
             while(!(rs.next()))
             {

             if(server.equals("cost")){
     //System.out.println("fee");
     if(cost.equals("2000")){
     String Qu="insert into server (S_Uid,S_UserName,S_Server,S_Cost) values('"+id+"','"+first+"','"+server+"','"+cost+"')";
     PreparedStatement pss =DbConnection_1.getconnection().prepareStatement(Qu);
     int s=pss.executeUpdate();
      response.sendRedirect("ServerBuyed.jsp");
     }
     response.sendRedirect("ChooseServerError.jsp");
 }
 else if(server.equals("free")){
String Qu="insert into server (S_Uid,S_UserName,S_Server,S_Cost) values('"+id+"','"+first+"','"+server+"','No Edit')";
     PreparedStatement ps1 =DbConnection_1.getconnection().prepareStatement(Qu);
     int s1=ps1.executeUpdate();
     response.sendRedirect("ServerBuyed.jsp");
 }response.sendRedirect("ChooseServerError.jsp");
 return;
 }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////<%%>

             System.out.println("feessssssss");
             if(server.equals("cost")){
              if(cost.equals("2000")){
             String Qu="update  server set S_Server='"+server+"',S_Cost='cost' where S_Uid='"+id+"' ";
     PreparedStatement ps1 =DbConnection_1.getconnection().prepareStatement(Qu);
     int s1=ps1.executeUpdate();
      response.sendRedirect("ServerBuyed.jsp");
      return;
                 }
                 response.sendRedirect("ChooseServerError.jsp");
                 return;
             }else if(server.equals("free")){
String Qu="update  server set S_Server='"+server+"',S_Cost='No Edit' where S_Uid='"+id+"' ";
     PreparedStatement ps1 =DbConnection_1.getconnection().prepareStatement(Qu);
     int s1=ps1.executeUpdate();
     response.sendRedirect("ServerBuyed.jsp");
 }response.sendRedirect("ChooseServerError.jsp");
 return;

        }catch(Exception e){
            System.out.println(e);
        } finally { 
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
