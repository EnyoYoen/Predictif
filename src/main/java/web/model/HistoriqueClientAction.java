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
public class HistoriqueClientAction extends Action {

    public HistoriqueClientAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");

        try {
            Long id;
            if (clientId == null && request.getSession().getAttribute("type") != null
                    && request.getSession().getAttribute("type").equals("client")) {
                id = (Long)request.getSession().getAttribute("id");
            } else {
                id = Long.parseLong(clientId);
            }
            Client client = (Client)service.findIndividuById(id);
            request.setAttribute("client", client);
            request.setAttribute("listeConsultations", null);
            // SERVICE NON IMPLEMENTE PAR L'ANCIEN GROUPE ??
            //List<Consultation> consultations = service.getHistoriqueClient(client);
            //request.setAttribute("listeConsultations", consultations);
        } catch (NumberFormatException e) {
            request.setAttribute("listeConsultations", null);
        }
    }
}
