package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import metier.modele.Medium;
import metier.service.Service;

public class SortedMediumListAction extends Action {
    public SortedMediumListAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Medium> mediumList = service.getOrderedListMediums();
        request.setAttribute("mediumList", mediumList);
    }
}
