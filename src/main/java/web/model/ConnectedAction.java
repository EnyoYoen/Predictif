/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class ConnectedAction extends Action {

    public ConnectedAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        request.setAttribute("connected", request.getSession().getAttribute("id") != null);
        request.setAttribute("type", request.getSession().getAttribute("type"));
    }
}
