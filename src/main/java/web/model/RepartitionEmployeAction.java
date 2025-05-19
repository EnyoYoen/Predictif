package web.model;

import javax.servlet.http.HttpServletRequest;

import metier.modele.Employe;

public class RepartitionEmployeAction extends Action {
    public RepartitionEmployeAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");
        Client client = service.findClientById(clientId);
        if (client != null) {
            List<Pair<Employe, Integer>> repartition = service.getRepartitionParEmp(client);
            request.setAttribute("repartition", repartition);
        } else {
            request.setAttribute("repartition", null);
        }
    }
}
