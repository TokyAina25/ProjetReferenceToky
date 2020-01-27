/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AutresFonction;
import dao.Generaliser;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.BaseModele;
import model.Developpeur;
import model.OccupationDeveloppeur;
import model.Projets;
import model.Teammembrevue;
import model.Utilisateurs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OTME
 */
@Controller
public class AdminController {
      private Generaliser general;
      private AutresFonction fonction;
    
      @RequestMapping(
              value = "/",
              method = RequestMethod.GET
      )
      public ModelAndView Index(HttpServletRequest hsr) throws Exception {          
          return new ModelAndView("index");
      }
      
       @RequestMapping(
              value = "/pages",
              method = RequestMethod.GET
      )
      public ModelAndView Pages(HttpServletRequest hsr, int profil) throws Exception {
          ModelAndView mv = null;
          general = new Generaliser();
          fonction = new AutresFonction();          
          try{
              List<BaseModele> utilisateurs = general.findAll(new Utilisateurs());
              List<BaseModele> projets = general.findAll(new Projets());
                if(profil==1){
                    hsr.setAttribute("users", utilisateurs);
                    mv = new ModelAndView("bienvenue");
                }if(profil==2){
                    hsr.setAttribute("projets", projets);
                    mv = new ModelAndView("bienvenueManager");
                }if(profil==3){

                }
          }catch(Exception ex){
              
          }
         
          return mv;
      }
      
      @RequestMapping(
              value = "/auth",
              method = RequestMethod.POST
      )
      public ModelAndView Auth(HttpServletRequest hsr) throws Exception {          
         //String pages = "redirect:/index.jsp?contenue=platsrestaurant";
        ModelAndView mv = null;
        HttpSession session = hsr.getSession(); 
        List<BaseModele> listes = new ArrayList<>();
        Utilisateurs utilisateur = null;
        general = new Generaliser();
          try {
              String user = hsr.getParameter("nom");
              String mdp = hsr.getParameter("mdp");
              String profil = hsr.getParameter("profil");
              listes = general.find(new Utilisateurs(), "nomutilisateur='"+user+"' and mdp='"+mdp+"'", 1, 0);
              System.out.println("profil "+Integer.valueOf(profil));
              if(listes.size()==1){
                  utilisateur =(Utilisateurs) listes.get(0);
                  utilisateur.setMdp("*****");
                  session.setAttribute("utilisateur", utilisateur);
                  mv = Pages(hsr , Integer.valueOf(profil));
              }else{
                  hsr.setAttribute("erreur", "Login incorrecte");
                  mv = Index(hsr);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }          
          return mv;
     }
      
       @RequestMapping(
              value = "/supprimerUser",
              method = RequestMethod.GET
      )
      public ModelAndView spprimerUser(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        HttpSession session = hsr.getSession(); 
          try {
             String iduser = hsr.getParameter("iduser");
             List<BaseModele> listes = general.find(new Utilisateurs(), "id="+iduser, 1, 0);
             Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
             general.delete((Utilisateurs) listes.get(0));
             mv = Pages(hsr,1);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return mv;
     }
      
       @RequestMapping(
              value = "/updateUser",
              method = RequestMethod.POST
      )
      public ModelAndView updateUser(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        HttpSession session = hsr.getSession(); 
          try {
             Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
             String iduser = hsr.getParameter("identifiant");
             String email = hsr.getParameter("email");
             String nom = hsr.getParameter("nom");
             String profil = hsr.getParameter("profil");
             List<BaseModele> listes = general.find(new Utilisateurs(), "id="+iduser, 1, 0);
             Utilisateurs temp = (Utilisateurs) listes.get(0);
             Utilisateurs user = new Utilisateurs(nom, temp.getMdp(), email, Integer.valueOf(iduser));
             general.update(user);
             mv = Pages(hsr,1);
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
     }
      
       @RequestMapping(
              value = "/insererUser",
              method = RequestMethod.POST
      )
      public ModelAndView insererUser(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
        HttpSession session = hsr.getSession(); 
          try {
             Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
             String email = hsr.getParameter("email");
             String nom = hsr.getParameter("nom");
             String mdp = hsr.getParameter("mdp");
             Utilisateurs user = new Utilisateurs(nom, mdp, email);
             general.save(user);
             mv = Pages(hsr,1);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return mv;
     }
     
      @RequestMapping(
              value = "/deconnection",
              method = RequestMethod.GET
      )
      public ModelAndView Deconnection(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        HttpSession session = hsr.getSession(); 
          try {
             session.invalidate();
             mv = new ModelAndView("index");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
     }
      
      @RequestMapping(
              value = "/pageProjet",
              method = RequestMethod.GET
      )
      public ModelAndView pageProjet(HttpServletRequest hsr) throws Exception {
        ModelAndView mv = null;
        general = new Generaliser();
          try {
             List<BaseModele> projets = general.findAll(new Projets());
             hsr.setAttribute("projets", projets);
             mv = new ModelAndView("bienvenue.jsp?contenue=projet");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
      }
      
      @RequestMapping(
              value = "/tache",
              method = RequestMethod.GET
      )
      public ModelAndView tache(HttpServletRequest hsr) throws Exception {
        ModelAndView mv = null;
        general = new Generaliser();
          try {
             mv = new ModelAndView("bienvenue.jsp?contenue=tache");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
      }
      
      @RequestMapping(
              value = "/projet",
              method = RequestMethod.GET
      )
      public ModelAndView Projet(HttpServletRequest hsr) throws Exception {
          ModelAndView mv = null;
          general = new Generaliser();
          fonction = new AutresFonction();
          HttpSession session = hsr.getSession(); 
          
          try{
             String idProjet = hsr.getParameter("idprojet");
             List<BaseModele> listes = general.find(new Projets(), "id="+idProjet, 1, 0);
             List<BaseModele> developpeur = general.find(new Teammembrevue(), "projet="+idProjet, 10, 0);
             Projets projet = (Projets) listes.get(0);
             Utilisateurs leader = (Utilisateurs) general.find(new Utilisateurs(), "id="+projet.getIdmanager(), 1, 0).get(0);
             List<BaseModele> users = general.findAll(new Utilisateurs());
             session.setAttribute("projet", projet);
             hsr.setAttribute("leader", leader);
             hsr.setAttribute("users", users);
             hsr.setAttribute("developpeur", developpeur);
             mv = new ModelAndView("bienvenue.jsp?contenue=affectationprojet");
          }catch(Exception ex){
              throw ex;
          }
          return mv;
      }
      
      @RequestMapping(
              value = "/assignerUser",
              method = RequestMethod.POST
      )
      public ModelAndView AssignerUser(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
        HttpSession session = hsr.getSession(); 
          try {
             Projets projet = (Projets) session.getAttribute("projet");
             String iduser = hsr.getParameter("iduser");
             System.out.println("user "+iduser);
             //Teammembre membre = new Teammembre(Integer.valueOf(iduser),projet.getId(),3,);
             //general.save(membre);
             mv = Projet(hsr);
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
     }
      
      @RequestMapping(
              value = "/occupation",
              method = RequestMethod.POST
      )
      public ModelAndView Occupation(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
        HttpSession session = hsr.getSession(); 
          try {
             Projets projet = (Projets) session.getAttribute("projet");
             String iduser = hsr.getParameter("iduser");
             System.out.println("user "+iduser);
             //Teammembre membre = new Teammembre(Integer.valueOf(iduser),projet.getId());
             //general.save(membre);
             mv = new ModelAndView("bienvenueManager");
          } catch (Exception e) {
              e.printStackTrace();
          }
          return mv;
     }
      
      @RequestMapping(
              value = "/equipe",
              method = RequestMethod.POST
      )
      public ModelAndView Equipe(HttpServletRequest hsr) throws Exception {          
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
        HttpSession session = hsr.getSession(); 
          try {
             Projets projet = (Projets) session.getAttribute("projet");
             String iduser = hsr.getParameter("iduser");
             System.out.println("user "+iduser);
             //Teammembre membre = new Teammembre(Integer.valueOf(iduser),projet.getId());
             //general.save(membre);
             mv = new ModelAndView("bienvenueManager");
          } catch (Exception e) {
              e.printStackTrace();
          }
          return mv;
     }
      
      @RequestMapping(
              value = "/devs",
              method = RequestMethod.GET
      )
      public ModelAndView devs(HttpServletRequest hsr) throws Exception {
        ModelAndView mv = null;
        general = new Generaliser();
          try {
             List<BaseModele> dev = general.findAll(new Developpeur());
             hsr.setAttribute("developpeur", dev);
             mv = new ModelAndView("bienvenue.jsp?contenue=developpeur");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
      }
      
       @RequestMapping(
              value = "/occupation",
              method = RequestMethod.GET
      )
      public ModelAndView occupationdev(HttpServletRequest hsr) throws Exception {
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
          try {
             String idprojet = hsr.getParameter("idprojet");
             List<OccupationDeveloppeur> occupation = fonction.findAllAffichesProduits(Integer.valueOf(idprojet));
             hsr.setAttribute("occupation", occupation);
             mv = new ModelAndView("bienvenue.jsp?contenue=occupationdeveloppeur");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
      }
      
      @RequestMapping(
              value = "/occupationdate",
              method = RequestMethod.POST
      )
      public ModelAndView occupationdate(HttpServletRequest hsr) throws Exception {
        ModelAndView mv = null;
        general = new Generaliser();
        fonction = new AutresFonction();
          try {
             String idprojet = hsr.getParameter("idprojet");
             String datedebut = hsr.getParameter("datedebut");
             String datefin = hsr.getParameter("datefin");
             List<OccupationDeveloppeur> occupation = fonction.findAllAffichesProduits(Integer.valueOf(idprojet),Date.valueOf(datedebut),Date.valueOf(datefin));
             hsr.setAttribute("occupation", occupation);
             mv = new ModelAndView("bienvenue.jsp?contenue=occupationdeveloppeur");
          } catch (Exception e) {
              e.printStackTrace();
          }
          
          return mv;
      }
      
      //select idprojet,sum(estimation)/sum(tempspasse) as tempspasse from taches group by idprojet occupationdev
      
}
