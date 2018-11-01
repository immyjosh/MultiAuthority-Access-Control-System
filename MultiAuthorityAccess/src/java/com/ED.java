/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.DbConnection_1.con;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sai Krishna
 */
public class ED extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     String id,mail;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            id=request.getParameter("id");
           // out.println(id);
            HttpSession session = request.getSession();
            String Cname=session.getAttribute("Cname").toString();
            String bbb=session.getAttribute("s").toString();
           // out.println(Cname);
        PreparedStatement ps=con.prepareStatement("select * from client_registration where C_First='"+Cname+"'");
        ResultSet s=ps.executeQuery();
while(s.next())
{
   mail=s.getString("C_Email");
}
       
            String from="demorajalpha";
	         String password="alpha123456";
                 String to[]= new String[1];
	                to[0]=mail;//to ur frnd
	                
	              System.out.println(mail);

	              String message=id;
                      String subject="Secret Key ";
	          
	         
	         mail m=new mail();
	         m.sendFromGMail(from, password, to, subject,message);
	         System.out.println("Mail Sent");
               RequestDispatcher rd=request.getRequestDispatcher("/ViewEdit.jsp");
		rd.include(request, response);
        }
    catch (Exception ex) {
            Logger.getLogger(ED.class.getName()).log(Level.SEVERE, null, ex);
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
