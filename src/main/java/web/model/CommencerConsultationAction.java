package web.model;

import metier.modele.Consultation;

public class CommencerConsultationAction extends Action {

    public CommencerConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String consultationId = request.getParameter("consultationId");
        Consultation consultation = service.findConsultationById(consultationId);
        service.employePret(consultation);
    }
}