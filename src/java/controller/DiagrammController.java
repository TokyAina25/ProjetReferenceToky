/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AutresFonction;
import dao.Generaliser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.BaseModele;
import model.Diagramme;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OTME
 */
@Controller
public class DiagrammController {
    
    private Generaliser general;
    private AutresFonction fonction;
    
     @RequestMapping(
              value = "/diagramme",
              method = RequestMethod.GET
      )
     public ModelAndView Deconnection(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
          try {
             String idProjet = hsr.getParameter("idprojet");
             List<BaseModele> listes = general.find(new Diagramme(), "idprojet="+idProjet, 10, 0);
             hsr.setAttribute("diagramme", listes);
             mv = new ModelAndView("bienvenue.jsp?contenue=diagram");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
     }
}
