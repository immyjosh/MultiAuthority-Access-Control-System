package com;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name="LoginCheck", urlPatterns={"/LoginCheck"})
public class LoginCheck extends HttpServlet {
   
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

            String username=request.getParameter("username");
            
            String password=request.getParameter("password");
            System.out.println(username + " "+ password );
if(username.equals("admin")&&password.equals("admin")){

response.sendRedirect("AdminHome.jsp");
return;
}
            
                String qu="select * from dataowner_registration where D_UserName='"+username+"' and D_Password='"+password+"'";
                PreparedStatement ps = DbConnection_1.getconnection().prepareStatement(qu);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    String status=rs.getString("D_Status");
                    String Dataid=rs.getString("D_Id");
                    System.out.println(status);
                    if(status.equals("Active")){
                        String SessName=rs.getString("D_First");
                        HttpSession session=request.getSession();
                        session.setAttribute("Sessname", SessName);
                        session.setAttribute("DID", Dataid);
                    response.sendRedirect("DataOwnerHomePage.jsp");
                    return;
                    }else
                    {
                    response.sendRedirect("LoginFailed.jsp");
                    }response.sendRedirect("LoginFailed.jsp");
               }
           

             if(!(username.equals("")) && (!password.equals("")))
            // System.out.println("hello");
             {
                String qua="select * from client_registration where C_UserName='"+username+"' and C_Password='"+password+"'";
                PreparedStatement psa = DbConnection_1.getconnection().prepareStatement(qua);
                ResultSet rs1=psa.executeQuery();
                //System.out.println("hello");
                while(rs1.next()){
                    String statusa=rs1.getString("C_Status");
                    String Dataida=rs1.getString("C_Id");
                    System.out.println(statusa);
                    String CName=rs1.getString("C_First");
                    String ownid=rs1.getString("C_Owner");
                    if(statusa.equals("Active")){
                        // System.out.println("hello");
                        
                        HttpSession session=request.getSession();
                        session.setAttribute("Cname", CName);
                        session.setAttribute("CID", Dataida);
                        session.setAttribute("ownid", ownid);
                        System.out.println("hello");
                      response.sendRedirect("ClientHomePage.jsp");
                      return;
                    }else
                    {
                    response.sendRedirect("LoginFailed.jsp");
                    }response.sendRedirect("LoginFailed.jsp");
               }response.sendRedirect("LoginFailed.jsp");
            }
       
        

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
