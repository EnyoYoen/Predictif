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
        try {
            Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
            Long consEmpId = consultation.getEmploye().getId();
            Long indId = (Long) request.getSession().getAttribute("id");
            String comment = request.getParameter("comment");
            if (indId == null || consEmpId == null || !indId.equals(consEmpId)) {
                request.setAttribute("error", indId == null ? "Non connecté" : consEmpId == null ? "Vous n'êtes pas employé" : "Vous ne pouvez pas démarrer cette consultation");
            } else {
                service.validerConsultation(consultation, comment);
                request.getSession().setAttribute("consultation", null);
                request.setAttribute("error", false);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Pas de consultation en cours");
        }
    }
}