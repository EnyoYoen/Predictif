/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.vue;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.modele.Employe;
import metier.modele.Individu;

/**
 *
 * @author ypeyrot
 */
public class IndividuSerialisation {

    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        response.setContentType("application/json;charset=UTF-8");
        Individu individu = (Individu) request.getAttribute("ind");

        /*
         * GsonBuilder builder = new GsonBuilder();
         * 
         * builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
         * 
         * @Override
         * public boolean shouldSkipField(FieldAttributes f) {
         * return f.getName().equals("mdp");
         * }
         * 
         * @Override
         * public boolean shouldSkipClass(Class<?> clazz) {
         * return false;
         * }
         * });
         * 
         * Gson gson = builder.create();
         * 
         * out.println(gson.toJson(individu));
         */
        if (individu != null) {
            out.println("{\"etat\":" + (individu instanceof Employe ? "\"employee\"" : "\"client\"") + "}");
        }

        out.close();
    }
}
