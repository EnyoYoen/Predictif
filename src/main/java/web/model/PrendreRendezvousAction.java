package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Employe;
import metier.modele.Medium;
import metier.service.Service;

public class PrendreRendezvousAction extends Action {
    public PrendreRendezvousAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");
        String mediumId = request.getParameter("mediumId");
        
        try {
            Long idc = Long.parseLong(clientId);
            Long idm = Long.parseLong(mediumId);
            
            Client client = (Client)service.findIndividuById(idc);
            Medium medium = service.findMediumById(idm);
            if (client == null || medium == null) {
                request.setAttribute("error", true);
                request.setAttribute("available", null);
            } else {
                Employe employe = service.priseRDV(client, medium);
                request.setAttribute("error", false);
                request.setAttribute("available", true);
            }
        } catch (Exception e) {
            request.setAttribute("error", true);
            request.setAttribute("available", null);
        }
    }
}
