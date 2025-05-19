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
public abstract class Action {

    protected Service service;

    public Action(Service service) {
        this.service = service;
    }

    public abstract void execute(HttpServletRequest request);
}
