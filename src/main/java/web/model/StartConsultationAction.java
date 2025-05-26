package web.model;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Consultation;
import metier.service.Service;

public class StartConsultationAction extends Action {

    public StartConsultationAction(Service service) {
        super(service);
    }

    @Override
    public void execute(HttpServletRequest request) {
        try {
            Consultation consultation = (Consultation) request.getSession().getAttribute("consultation");
            Long consEmpId = consultation.getEmploye().getId();
            Long indId = (Long) request.getSession().getAttribute("id");
            if (indId == null || consEmpId == null || !indId.equals(consEmpId)) {
                request.setAttribute("error", indId == null ? "Non connecté" : consEmpId == null ? "Vous n'êtes pas employé" : "Vous ne pouvez pas démarrer cette consultation");
            } else {
                service.employePret(consultation);
                request.setAttribute("error", false);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Pas de consultation en cours");
        }
    }
}