/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;


import com.emergentes.dao.ParticipanteDao;
import com.emergentes.dao.ParticipanteDaoImplementacion;
import com.emergentes.modelo.Participante;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ParticipanteControlador", urlPatterns = {"/ParticipanteControlador"})
public class ParticipanteControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try 
        {
            ParticipanteDao dao = new ParticipanteDaoImplementacion();
            Participante par = new Participante();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("participante", par);
                    request.getRequestDispatcher("participante_form.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    par= dao.getById(id);
                    request.setAttribute("cliente", par);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ParticipanteControlador");
                    break;
                case "view":
                    List<Participante> lista = dao.getAll();
                    request.setAttribute("participante", lista);
                    request.getRequestDispatcher("participante_listado.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id_seminario = Integer.parseInt (request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt (request.getParameter("id_seminario"));
        Participante par = new Participante();
        par.setId(id);
        par.setNombres(nombres);
        par.setApellidos(apellidos);
        par.setId_seminario(id_seminario);
        par.setConfirmado(confirmado);
        Participante dao = new ParticipanteDaoImplementacion();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(par);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(par);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("ClienteControlador");
      
    
    }

}
