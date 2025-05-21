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
import web.model.CommencerConsultationAction;
import web.model.ConnexionAction;
import web.model.CurrentConsultationAction;
import web.model.HistoriqueClientAction;
import web.model.InfosMediumAction;
import web.model.InscriptionAction;
import web.model.ListeClientsContenantAction;
import web.model.ListeMediumOrdonneeAction;
import web.model.PredictionAction;
import web.model.PrendreRendezvousAction;
import web.model.RepartitionClientAction;
import web.model.RepartitionEmployeAction;
import web.model.TerminerConsultationAction;
import web.model.TopMediumAction;
import web.vue.ClientSerialisation;
import web.vue.ConnexionSerialisation;
import web.vue.CurrentConsultationSerialisation;
import web.vue.MediumSerialisation;
import web.vue.IndividuSerialisation;
import web.vue.ListeClientSerialisation;
import web.vue.ListeConsultationSerialisation;
import web.vue.ListeMediumSerialisation;
import web.vue.PredictionSerialisation;
import web.vue.PrendreRendezvousSerialisation;
import web.vue.RepartitionClientSerialisation;
import web.vue.RepartitionEmployeSerialisation;

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
        //service.initialisationBD();
        switch (todo) {
            case "accueil_connexion":
                new AccueilConnexionAction(service).execute(req);
                new ConnexionSerialisation().apply(req, res);
                break;
            case "accueil_liste_medium":
                new AccueilListeMediumAction(service).execute(req);
                new ListeMediumSerialisation().apply(req, res);
                break;
            case "infos_medium":
                new InfosMediumAction(service).execute(req);
                new MediumSerialisation().apply(req, res);
                break;
            case "infos_page_employee":
                new CurrentConsultationAction(service).execute(req);
                new CurrentConsultationSerialisation().apply(req, res);
                break;
            case "prediction":
                new PredictionAction(service).execute(req);
                new PredictionSerialisation().apply(req, res);
                break;
            case "historique_client":
                new HistoriqueClientAction(service).execute(req);
                new ListeConsultationSerialisation().apply(req, res);
                break;
            case "top_medium":
                new TopMediumAction(service).execute(req);
                new ListeMediumSerialisation().apply(req, res);
                break;
            case "liste_clients_contenant":
                new ListeClientsContenantAction(service).execute(req);
                new ListeClientSerialisation().apply(req, res);
                break;
            case "commencer_consultation":
                new CommencerConsultationAction(service).execute(req);
                break;
            case "terminer_consultation":
                new TerminerConsultationAction(service).execute(req);
                break;
            /*case "liste_clients":
                new ListeClientsAction(service).execute(req);
                new ListeClientSerialisation().apply(req, res);
                break;*/
            case "repartition_employe":
                new RepartitionEmployeAction(service).execute(req);
                new RepartitionEmployeSerialisation().apply(req, res);
                break;
            case "repartition_client":
                new RepartitionClientAction(service).execute(req);
                new RepartitionClientSerialisation().apply(req, res);
                break;
            case "liste_medium_ordonnee":
                new ListeMediumOrdonneeAction(service).execute(req);
                new ListeMediumSerialisation().apply(req, res);
                break;
            case "prendre_rendez_vous":
                new PrendreRendezvousAction(service).execute(req);
                new PrendreRendezvousSerialisation().apply(req, res);
                break;
            case "connexion":
                new ConnexionAction(service).execute(req);
                new IndividuSerialisation().apply(req, res);
                break;
            case "inscription":
                new InscriptionAction(service).execute(req);
                new ClientSerialisation().apply(req, res);
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
