/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import javax.servlet.http.HttpServletRequest;
import metier.service.Service;
import metier.modele.Medium;
import java.util.List;

/**
 *
 * @author ypeyrot
 */
public class MediumListAction extends Action {

    public MediumListAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        List<Medium> mediumList = service.getListeMediums();
        request.setAttribute("mediumList", mediumList);
    }
}
