package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Consultation;
import metier.service.Service;

public class EndConsultationAction extends Action {
    public EndConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String consultationId = request.getParameter("consultationId");
        String comment = request.getParameter("comment");
        try {
            Long id = Long.parseLong(consultationId);
            Consultation consultation = service.findConsultationById(id);
            service.validerConsultation(consultation, comment);
        } catch (Exception e) {

        }
    }
}