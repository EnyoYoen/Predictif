/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controller;

import dao.JpaUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.service.Service;
import web.model.AccueilConnexionAction;
import web.model.AccueilListeMediumAction;
import web.model.ConnexionAction;
import web.model.CurrentConsultationAction;
import web.model.InfosMediumAction;
import web.model.InscriptionAction;
import web.vue.ConnexionSerialisation;
import web.vue.CurrentConsultationSerialisation;
import web.vue.MediumSerialisation;
import web.vue.IndividuSerialisation;

/**
 *
 * @author ypeyrot
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) {
        String todo = req.getParameter("todo");
        if (todo == null) {
            return;
        }
        Service service = new Service();
        service.initialisationBD();
        switch (todo) {
            case "accueil_connexion":
                new AccueilConnexionAction(service).execute(req);
                new ConnexionSerialisation().apply(req, res);
                break;
            case "accueil_liste_medium":
                new AccueilListeMediumAction(service).execute(req);
                new MediumSerialisation().apply(req, res);
                break;
            case "infos_medium":
                new InfosMediumAction(service).execute(req);
                new MediumSerialisation().apply(req, res);
                break;
            case "infos_page_employee":
                new CurrentConsultationAction(service).execute(req);
                new CurrentConsultationSerialisation().apply(req, res);
                break;
            case "connexion":
                new ConnexionAction(service).execute(req);
                new IndividuSerialisation().apply(req, res);
                break;
            case "inscription":
                new InscriptionAction(service).execute(req);
                break;
            default:
                break;
        }
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        JpaUtil.creerFabriquePersistance();
    }

    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
