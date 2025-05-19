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

/**
 *
 * @author ypeyrot
 */
public class ConnexionSerialisation {

    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        
        Map<String, Object> data;
        
        if (request.getAttribute("connected") != null && request.getAttribute("type") != null) {
            data = new HashMap<>();
            data.put("connected", request.getAttribute("connected"));
            data.put("type", request.getAttribute("type"));

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String json = gson.toJson(data);

            out.println(json);
        } else {
            data = new HashMap<>();
            data.put("connected", false);
            data.put("type", null);
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(data);

        out.println(json);

        out.close();
    }
}
