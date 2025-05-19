package web.model;

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