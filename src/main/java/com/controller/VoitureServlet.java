package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Voiture;
import com.crud.DAO;
import com.gestion.GestionVoitureDAO;


public class VoitureServlet extends HttpServlet {

	   Voiture v = new Voiture();
       DAO gs = new GestionVoitureDAO();
       
       
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
       }
       
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
    	   System.out.println("I am in the servlet");
    	   if(request.getParameter("ajoutVoiture")!=null){
               String nom = request.getParameter("nom");
               String matricule = request.getParameter("matricule");
               v.setNom(nom);
               v.setMatricule(matricule);
               gs.insert(v);
               RequestDispatcher rd = request.getRequestDispatcher("AjouterVoiture.jsp");
               rd.forward(request, response);
           }
    	   
            if(request.getParameter("afficherVoiture")!=null){
               List<Voiture> voitureList = new ArrayList();
               voitureList = gs.all();
               request.setAttribute("voitureList", voitureList);
               RequestDispatcher rd = request.getRequestDispatcher("AfficherVoitures.jsp");
               rd.forward(request, response);
           }
            
             if(request.getParameter("modifiervoiture")!=null){
                Long id = Long.parseLong(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String mat = request.getParameter("mat");
                v.setId(id); v.setNom(nom); v.setMatricule(mat); 
                gs.update(v);                 
                RequestDispatcher rd = request.getRequestDispatcher("AjouterVoiture.jsp");
                rd.forward(request, response);                    
            }
             
            if(request.getParameter("supprimervoiture")!=null){
               Long idx = Long.parseLong(request.getParameter("id"));
               gs.delete(idx);
               RequestDispatcher rd = request.getRequestDispatcher("SupprimerVoiture.jsp");
               rd.forward(request, response);
            } 
                         
        }
           
}


