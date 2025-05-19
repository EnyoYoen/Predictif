package web.model;

import javax.servlet.http.HttpServletRequest;

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