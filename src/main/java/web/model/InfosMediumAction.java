/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.modele.Medium;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class InfosMediumAction extends Action {

    public InfosMediumAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        Medium medium = null;
        if (id != null) {
            medium = Service.findMediumById();
        } else {
            medium = null;
        }
        request.setAttribute("medium", medium);
    }
}
