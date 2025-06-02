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
import web.model.AppointmentAction;
import web.model.ClientDistributionAction;
import web.model.ClientHistoryAction;
import web.model.ClientListSearchAction;
import web.model.ConnectedAction;
import web.model.CurrentConsultationAction;
import web.model.DisconnectAction;
import web.model.EmployeeDistributionAction;
import web.model.EndConsultationAction;
import web.model.LoginAction;
import web.model.MediumListAction;
import web.model.MediumInfosAction;
import web.model.PredictionAction;
import web.model.RegisterAction;
import web.model.SortedMediumListAction;
import web.model.StartConsultationAction;
import web.model.TopMediumAction;
import web.vue.AppointmentSerialisation;
import web.vue.ClientDistributionSerialisation;
import web.vue.ClientListSerialisation;
import web.vue.ConsultationListClientSerialisation;
import web.vue.ConsultationListSerialisation;
import web.vue.CurrentConsultationSerialisation;
import web.vue.EmployeeDistributionSerialisation;
import web.vue.ErrorSerialisation;
import web.vue.IndividuSerialisation;
import web.vue.LoginSerialisation;
import web.vue.MediumListSerialisation;
import web.vue.MediumSerialisation;
import web.vue.PredictionSerialisation;
import web.vue.RegisterSerialisation;

/**
 *
 * @author ypeyrot
 */
@WebServlet(name = "ActionServlet", urlPatterns = { "/ActionServlet" })
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) {
        String todo = req.getParameter("todo");
        if (todo == null) {
            return;
        }
        Service service = new Service();
        // service.initialisationBD();
        switch (todo) {
            case "connected":
                new ConnectedAction(service).execute(req);
                new LoginSerialisation().apply(req, res);
                break;
            case "medium_list":
                new MediumListAction(service).execute(req);
                new MediumListSerialisation().apply(req, res);
                break;
            case "medium_infos":
                new MediumInfosAction(service).execute(req);
                new MediumSerialisation().apply(req, res);
                break;
            case "employee_page_infos":
                new CurrentConsultationAction(service).execute(req);
                new CurrentConsultationSerialisation().apply(req, res);
                break;
            case "prediction":
                new PredictionAction(service).execute(req);
                new PredictionSerialisation().apply(req, res);
                break;
            case "client_history":
                new ClientHistoryAction(service).execute(req);
                new ConsultationListSerialisation().apply(req, res);
                break;
            case "top_medium":
                new TopMediumAction(service).execute(req);
                new MediumListSerialisation().apply(req, res);
                break;
            case "client_list_search":
                new ClientListSearchAction(service).execute(req);
                new ClientListSerialisation().apply(req, res);
                break;
            case "start_consultation":
                new StartConsultationAction(service).execute(req);
                new ErrorSerialisation().apply(req, res);
                break;
            case "end_consultation":
                new EndConsultationAction(service).execute(req);
                new ErrorSerialisation().apply(req, res);
                break;
            case "employee_distribution":
                new EmployeeDistributionAction(service).execute(req);
                new EmployeeDistributionSerialisation().apply(req, res);
                break;
            case "client_distribution":
                new ClientDistributionAction(service).execute(req);
                new ClientDistributionSerialisation().apply(req, res);
                break;
            case "sorted_medium_list":
                new SortedMediumListAction(service).execute(req);
                new MediumListSerialisation().apply(req, res);
                break;
            case "appointment":
                new AppointmentAction(service).execute(req);
                new AppointmentSerialisation().apply(req, res);
                break;
            case "login":
                new LoginAction(service).execute(req);
                new IndividuSerialisation().apply(req, res);
                break;
            case "register":
                new RegisterAction(service).execute(req);
                new RegisterSerialisation().apply(req, res);
                break;
            case "disconnect":
                new DisconnectAction(service).execute(req);
                new ErrorSerialisation().apply(req, res);
                break;
            default:
                break;
        }
    }

    @Override
    public void init() throws ServletException {
        super.init(); // To change body of generated methods, choose Tools | Templates.
        JpaUtil.creerFabriquePersistance();
    }

    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy(); // To change body of generated methods, choose Tools | Templates.
    }

}
