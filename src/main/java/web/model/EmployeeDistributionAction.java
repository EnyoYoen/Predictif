package web.model;

import java.util.List;
import javafx.util.Pair;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;

import metier.modele.Employe;
import metier.service.Service;

public class EmployeeDistributionAction extends Action {
    public EmployeeDistributionAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String clientId = request.getParameter("clientId");
        try {
            Long id = Long.parseLong(clientId);
            Client client = (Client) service.findIndividuById(id);
            if (client != null) {
                List<Pair<Employe, Integer>> distribution = service.getRepartitionParEmp(client);
                request.setAttribute("client", client);
                request.setAttribute("distribution", distribution);
            } else {
                request.setAttribute("client", null);
                request.setAttribute("distribution", null);
            }
        } catch (Exception e) {
            request.setAttribute("client", null);
            request.setAttribute("distribution", null);
        }
    }
}
