/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.*;
import javafx.scene.control.Alert;

/**
 *
 * @author chu_c
 */
public class operacionesunu extends HttpServlet {
    double numero1, numero2=0, k=1;
    double resultado=0;
    
    String OPERACION, MSJ="", suma;
    
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
        response.setContentType("text/html;charset=UTF-8");
        numero1=Integer.parseInt(request.getParameter("numero1"));
        numero2=Integer.parseInt(request.getParameter("numero2"));
        OPERACION=request.getParameter("operacion");
        suma=request.getParameter("suma");
        
        if(OPERACION.equals("suma")){
            resultado=numero1+numero2;
        }
        else
        if(OPERACION.equals("-")){
            resultado=numero1-numero2;
            MSJ="";
            
        }
        else
        if(OPERACION.equals("*")){
            resultado=numero1*numero2;
            MSJ="";
        }
        else
        if(OPERACION.equals("/")){
            if((numero2==0))
                MSJ="UN NUMERO NO SE PUEDE DIVIDIR ENTRE 0";
            else
            resultado=numero1/numero2;
            MSJ="";
        }
        else
        if(OPERACION.equals("sen")){
            resultado=(Math.sin(Math.toRadians(numero1)));
            MSJ="";

        }
        else
        if(OPERACION.equals("cos")){
             resultado=(Math.cos(Math.toRadians(numero1)));
             MSJ="";
        }
        else
        if(OPERACION.equals("tan")){
            if(resultado==90 || numero2==270)
                MSJ="LA TANGENTE DE 90 O 270 SE INDETERMINA";
            else{
             resultado=(Math.tan(Math.toRadians(numero1)));
             MSJ="";}
        }
        else
        if(OPERACION.equals("potencia")){
            if(numero2==0)
            {resultado=1;
            MSJ="";}
            else
            {
                resultado=Math.pow(numero1, numero2);
            }
        }
        else
        if(OPERACION.equals("cuadrado")){
            resultado=numero1*numero1;
            MSJ="";
        }
        else
        if(OPERACION.equals("doble")){
            resultado=numero1+numero1;
            MSJ="";
        }
        else if(OPERACION.equals("")){
            resultado=0;
            MSJ="SELECCIONE UNA OPERACION";
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<link rel='stylesheet' href='MiCSS.css'>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOperaciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado:" +resultado+ "</h1>");
            out.println("<h2>" +MSJ+ "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
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