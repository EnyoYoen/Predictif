package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Medium;
import metier.service.Service;

public class TopMediumAction extends Action {

    public TopMediumAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Medium> mediums = service.getTop5Mediums();
        request.setAttribute("listeMedium", mediums);
    }
}