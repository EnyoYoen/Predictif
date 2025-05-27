/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Individu;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class ClientHistoryAction extends Action {

    public ClientHistoryAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");

        try {
            Long id;
            if (clientId == null && request.getSession().getAttribute("type") != null
                    && request.getSession().getAttribute("type").equals("client")) {
                id = (Long) request.getSession().getAttribute("id");
            } else {
                id = Long.parseLong(clientId);
            }
            request.setAttribute("consultationList", null);
            // SERVICE NOT IMPLEMENTED BY THE PREVIOUS GROUP??
            // List<Consultation> consultations = service.getHistoriqueClient(client);
            // request.setAttribute("consultationList", consultations);
        } catch (NumberFormatException e) {
            request.setAttribute("consultationList", null);
        }
    }
}
