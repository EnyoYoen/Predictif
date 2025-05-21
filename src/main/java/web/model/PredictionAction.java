/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Individu;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class PredictionAction extends Action {

    public PredictionAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        try {
            Integer love = Integer.parseInt(request.getParameter("love"));
            Integer health = Integer.parseInt(request.getParameter("health"));
            Integer work = Integer.parseInt(request.getParameter("work"));
            Long clientId = Long.parseLong(request.getParameter("clientId"));
            
            Client client = (Client)service.findIndividuById(clientId);
            
            List<String> predictions = service.panneInspiration(client, love, health, work);
            
            request.setAttribute("predi_love", predictions.get(0));
            request.setAttribute("predi_health", predictions.get(1));
            request.setAttribute("predi_work", predictions.get(2));
        } catch (NumberFormatException e) {
            System.out.println("Error parsing parameters: " + e.getMessage());
            request.setAttribute("predi_love", null);
            request.setAttribute("predi_health", null);
            request.setAttribute("predi_work", null);
        }
    }
}
