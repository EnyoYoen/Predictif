package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import metier.modele.Medium;
import metier.service.Service;

public class ListeMediumOrdonneeAction extends Action {
    public ListeMediumOrdonneeAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Medium> mediums = service.getOrderedListMediums();
        request.setAttribute("listeMedium", mediums);
    }
}
