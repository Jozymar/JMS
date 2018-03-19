package com.ifpb.jms.whats;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EnviarWhatsServlet", urlPatterns = {"/whats"})
public class EnviarWhatsServlet extends HttpServlet {

    @Inject
    private EnviarWhats produtor;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String whats = request.getParameter("whats");
        String categoria = request.getParameter("categoria");
        this.produtor.enviar(categoria, whats);
        response.sendRedirect("whats.html");
            
        
    }

}
