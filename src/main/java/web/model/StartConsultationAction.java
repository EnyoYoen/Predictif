package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Consultation;
import metier.service.Service;

public class StartConsultationAction extends Action {

    public StartConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        String consultationId = request.getParameter("consultationId");
        try {
            Long id = Long.parseLong(consultationId);
            Consultation consultation = service.findConsultationById(id);
            service.employePret(consultation);
        } catch (Exception e) {
            
        }
    }
}