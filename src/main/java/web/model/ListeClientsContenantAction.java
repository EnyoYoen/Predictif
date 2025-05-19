package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.service.Service;

public class ListeClientsContenantAction extends Action {
    public ListeClientsContenantAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String subString = request.getParameter("subString");
        List<Client> clients = service.getListeClientsContainingName(subString);
        request.setAttribute("listeClients", clients);
    }
}