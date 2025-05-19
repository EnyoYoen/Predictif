/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import metier.modele.Client;
import metier.service.Service;

/**
 *
 * @author ypeyrot
 */
public class InscriptionAction extends Action {

    public InscriptionAction(Service service) {
        super(service);
    }

    public void execute(HttpServletRequest request) {
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String birthdate = request.getParameter("birthdate");
        String genre = request.getParameter("genre");

        DateFormat format = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(birthdate);
        } catch (ParseException ex) {
            request.setAttribute("client", null);
            return;
        }

        Client client = service.enregisterClient(new Client(address, date, lastname, firstname, phone, genre, password, mail));
        request.setAttribute("client", client);
        if (client != null) {
            request.getSession().setAttribute("id", client.getId());
            request.getSession().setAttribute("type", "client");
        }
    }
}
