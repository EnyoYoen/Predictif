package web.vue;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import metier.modele.Client;
import metier.modele.Consultation;

public class ConsultationListSerialisation extends Serialisation {
    @Override
    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        response.setContentType("application/json;charset=UTF-8");

        List<Consultation> consultations = (List<Consultation>) request.getAttribute("consultationList");
        Client client = (Client) request.getAttribute("client");

        Map<String, Object> data = new HashMap<>();
        data.put("client", client);
        data.put("consultationList", consultations);

        GsonBuilder builder = new GsonBuilder();

        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().equals("adresse") || f.getName().equals("numeroTel")
                    || f.getName().equals("mail") || f.getName().equals("genre")
                    || f.getName().equals("mdp") || f.getName().equals("historique")
                    || f.getName().equals("dateNaissance") || f.getName().equals("profilAstral")
                    || f.getName().equals("consultationEnCours");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });

        Gson gson = builder.create();

        out.println(gson.toJson(data));

        out.close();
    }
}
