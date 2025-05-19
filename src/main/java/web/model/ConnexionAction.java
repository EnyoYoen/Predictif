/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.modele.Individu;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class ConnexionAction extends Action {

    public ConnexionAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        Individu ind = service.verifiermdpIndividu(mail, password);
        request.setAttribute("individu", ind);
        
        if (ind != null) {
            request.getSession().setAttribute("mail", ind.getMail());
            request.getSession().setAttribute("type", ((ind instanceof Client) ? "client" : "employee"));
        }
    }
}
