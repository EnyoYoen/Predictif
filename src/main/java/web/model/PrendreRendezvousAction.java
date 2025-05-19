package web.model;

import metier.modele.Client;
import metier.modele.Employe;

public class PrendreRendezvousAction extends Action {
    public PrendreRendezvousAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");
        String mediumId = request.getParameter("mediumId");

        Client client = service.findClientById(clientId);
        Medium medium = service.findMediumById(mediumId);
        if (client == null || medium == null) {
            request.setAttribute("error", true);
            request.setAttribute("available", null);
        } else {
            Employe employe = service.priseRDV(client, medium);
            request.setAttribute("error", false);
            request.setAttribute("available", true);
        }
    }
}
