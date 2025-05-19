package web.model;

import metier.modele.Consultation;

public class TerminerConsultationAction extends Action {
    public TerminerConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String consultationId = request.getParameter("consultationId");
        String commentaire = request.getParameter("commentaire");
        Consultation consultation = service.findConsultationById(consultationId);
        service.terminerConsultation(consultation, commentaire);
    }
}