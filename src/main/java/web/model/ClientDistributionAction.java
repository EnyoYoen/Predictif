package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.service.Service;

import com.google.maps.model.LatLng;

public class ClientDistributionAction extends Action {
    public ClientDistributionAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<LatLng> distribution = service.getCoordClients();
        request.setAttribute("client_distribution", distribution);
    }
}