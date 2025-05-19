package web.model;

import javax.servlet.http.HttpServletRequest;

import metier.modele.Medium;

public class ListeMediumOrdonneeAction extends Action {
    public ListeMediumOrdonneeAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Medium> mediums = service.getOrderedListeMediums();
        request.setAttribute("listeMedium", mediums);
    }
}
