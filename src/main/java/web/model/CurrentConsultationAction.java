/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Employe;
import metier.modele.Individu;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class CurrentConsultationAction extends Action {

    public CurrentConsultationAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("id");
        Individu ind = service.findIndividuById(id);
        if (id != null && ind != null && ind instanceof Employe) {
            Consultation cons = ((Employe) ind).getConsultationEnCours();
            if (cons != null) {
                Client client = cons.getClient();
                Medium medium = cons.getMedium();
                request.setAttribute("consultation", cons);
                request.setAttribute("client", client);
                request.setAttribute("medium", medium);
            } else {
                request.setAttribute("consultation", null);
                request.setAttribute("client", null);
                request.setAttribute("medium", null);
            }
        } else {
            request.setAttribute("consultation", null);
            request.setAttribute("client", null);
            request.setAttribute("medium", null);
        }
    }
}
