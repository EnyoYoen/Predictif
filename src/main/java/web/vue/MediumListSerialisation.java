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

/**
 *
 * @author ypeyrot
 */
public class MediumListSerialisation {

    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        response.setContentType("application/json;charset=UTF-8");

        final boolean vueIndex = request.getAttribute("vue") == null || request.getAttribute("vue").equals("index");

        GsonBuilder builder = new GsonBuilder();

        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                boolean result = false;
                if (vueIndex) {
                    result = f.getName().equals("photoDeProfil") ||
                        f.getName().equals("genre") || f.getName().equals("nbConsultations") ||
                        f.getName().equals("formation")  || f.getName().equals("promotion") || 
                        f.getName().equals("support");
                } else {
                    result = f.getName().equals("description") ||
                        f.getName().equals("genre") || f.getName().equals("formation") || 
                        f.getName().equals("promotion") || f.getName().equals("support");
                }
                return result;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });

        Gson gson = builder.create();
        String json = gson.toJson(request.getAttribute("mediumList"));

        out.println(json);

        out.close();
    }
}
