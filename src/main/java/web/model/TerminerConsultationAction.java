package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Consultation;
import metier.service.Service;

public class TerminerConsultationAction extends Action {
    public TerminerConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String consultationId = request.getParameter("consultationId");
        String commentaire = request.getParameter("commentaire");
        try {
            
        } catch (Exception e) {
            Long id = Long.parseLong(consultationId);
            Consultation consultation = service.findConsultationById(id);
            service.validerConsultation(consultation, commentaire);
        }
    }
}