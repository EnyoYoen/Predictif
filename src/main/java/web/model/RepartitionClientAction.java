package web.model;

import javax.servlet.http.HttpServletRequest;

import com.google.maps.model.LatLng;

public class RepartitionClientAction extends Action {
    public RepartitionClientAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<LatLng> repartition = service.getCoordClients();
        request.setAttribute("repartitionClients", repartition);
    }
}