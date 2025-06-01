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

public class EmployeeDistributionSerialisation extends Serialisation {
    @Override
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
        data.put("client", request.getAttribute("client"));
        data.put("distribution", request.getAttribute("distribution"));

        GsonBuilder builder = new GsonBuilder();
        
        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().equals("adresse") || f.getName().equals("numeroTel")
                        || f.getName().equals("mail") || f.getName().equals("genre")
                        || f.getName().equals("mdp") || f.getName().equals("historique")
                        || f.getName().equals("dateNaissance") || f.getName().equals("profilAstral")
                        || f.getName().equals("nbConsultations") || f.getName().equals("id")
                        || f.getName().equals("consultationEnCours");
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