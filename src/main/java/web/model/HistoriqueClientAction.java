/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
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
        String idClient = request.getParameter("clientId");

        try {
            int id = Integer.parseInt(idClient);
            Client client = service.getClientById(id);
            List<Consultation> consultations = service.getHistoriqueClient(client);
            request.setAttribute("listeConsultations", consultations);
        } catch (NumberFormatException e) {
            request.setAttribute("listeConsultations", null);
        }
    }
}
