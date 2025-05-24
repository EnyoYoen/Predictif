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
public class LoginAction extends Action {

    public LoginAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        Individu ind = service.verifiermdpIndividu(mail, password);
        request.setAttribute("ind", ind);

        if (ind != null) {
            request.getSession().setAttribute("id", ind.getId());
            String type = ((ind instanceof Client) ? "client" : "employee");
            request.getSession().setAttribute("type", type);
        }

        request.setAttribute("connected", request.getSession().getAttribute("id") != null);
        request.setAttribute("type", request.getSession().getAttribute("type"));
    }
}
