/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.vue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.modele.Astrologue;
import metier.modele.Client;
import metier.modele.Consultation;
import metier.modele.Medium;
import metier.modele.Spirite;

/**
 *
 * @author ypeyrot
 */
public class CurrentConsultationSerialisation {

    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }

        Map<String, Object> data;

        data = new HashMap<>();
        data.put("consultation", (Consultation) request.getAttribute("consultation"));
        data.put("client", (Client) request.getAttribute("client"));
        data.put("medium", (Medium) request.getAttribute("medium"));

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(data);

        out.println(json);

        out.close();
    }
}
