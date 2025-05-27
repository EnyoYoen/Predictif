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
import metier.modele.Medium;
import metier.modele.Spirite;

/**
 *
 * @author ypeyrot
 */
public class MediumSerialisation {

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
        Medium medium = (Medium) request.getAttribute("medium");
        data.put("medium", medium);
        String type;
        if (medium instanceof Spirite) {
            type = "Spirite";
        } else if (medium instanceof Astrologue) {
            type = "Astrologue";
        } else {
            type = "Cartomancien";
        }
        data.put("class", type);

        GsonBuilder builder = new GsonBuilder();

        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().equals("genre") || f.getName().equals("nbConsultations");
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
