package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.service.Service;

public class DisconnectAction extends Action {
    public DisconnectAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute("error", false);
    }
}