/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.vue;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
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
        response.setContentType("application/json;charset=UTF-8");

        Client client = (Client) request.getAttribute("client");
        Medium medium = (Medium) request.getAttribute("medium");

        Map<String, Object> data;

        data = new HashMap<>();
        data.put("client", client);
        data.put("medium", medium);

        GsonBuilder builder = new GsonBuilder();
        
        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().equals("historique") || f.getName().equals("consultationEnCours");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        
        Gson gson = builder.create();
        String json = gson.toJson(data);

        out.println(json);

        out.close();
    }
}
