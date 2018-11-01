/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.DbConnection_1.con;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
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
public class ED2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String mail,filepath,filename;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      {
            try {
                //  id=request.getParameter("id");
                // out.println(id);
                HttpSession session = request.getSession();
                String Cname=session.getAttribute("cc").toString();
                out.println(Cname);
                session.setAttribute("Cname",Cname);
                filepath=session.getAttribute("filepath").toString();
        filename=session.getAttribute("filename").toString();
            session.setAttribute("filepath",filepath);
            session.setAttribute("filename", filename);
                //String bbb=session.getAttribute("s").toString();
                // out.println(Cname);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sharedauthority", "root","root");
                String q="select * from client_registration where C_First='"+Cname+"'";
                PreparedStatement ps=con.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    mail=rs.getString("C_Email");
                }
                out.println(mail);
//                
                String from="demorajalpha";
                String password="alpha123456";
                String to[]= new String[1];
                // HttpSession session1=request.getSession();
                // String toad="bhuvana.vlsa@gmail.com";
                to[0]=mail;//to ur frnd
                
                System.out.println(mail);
                String chars = "abcdefghijklmnopqrstuvwxyz"
                        + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "0123456789!@%$%&^?|~'\"#+="
                        + "\\*/.,:;[]()-_<>";
                
//                
////                    String chars = "abcdefghijklmnopqrstuvwxyz"
////                            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"            ///calculating the security key
////                            + "0123456789";
//                
//                
//                
                final int PW_LENGTH = 8;
                Random rnd = new SecureRandom();
                StringBuilder pass = new StringBuilder();
                for (int i = 0; i < PW_LENGTH; i++)
                    pass.append(chars.charAt(rnd.nextInt(chars.length())));
                String p=pass.toString();
                Random rr=new Random();
               // System.out.println(rr.nextInt(20)+1);
                int zzz=rr.nextInt(20)+1;
                String yyy=Integer.toString(zzz);
                // String message="";
                System.out.println(zzz);
                String nn="";
                PreparedStatement psss = con.prepareStatement("select * from capt where id='"+zzz+"'");
                ResultSet rss = psss.executeQuery();
                if(rss.next())
                {
                    nn=rss.getString("cont");
                }
               // String captcha = (String) session.getAttribute("captcha");
                String subject="Secret Key ";
                session.setAttribute("p", nn);
//                
                MailProjectClass m=new MailProjectClass();
                m.ma(mail, nn,yyy);
                
                System.out.println("Mail Sent");
 RequestDispatcher rd=request.getRequestDispatcher("/vi.jsp");
		rd.include(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ED2.class.getName()).log(Level.SEVERE, null, ex);
            }
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
