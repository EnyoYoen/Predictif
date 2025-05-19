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
import metier.modele.Employe;
import metier.modele.Individu;
import metier.modele.Medium;
import metier.modele.Spirite;

/**
 *
 * @author ypeyrot
 */
public class PredictionSerialisation {

    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        response.setContentType("application/json;charset=UTF-8");
        
        Map<String, Object> data;

        data = new HashMap<>();
        data.put("predi_love", request.getAttribute("predi_love"));
        data.put("predi_health", request.getAttribute("predi_health"));
        data.put("predi_work", request.getAttribute("predi_work"));

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(data);

        out.println(json);

        out.close();
    }
}
