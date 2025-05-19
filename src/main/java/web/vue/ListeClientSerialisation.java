package web.vue;

public class ListeClientSerialisation extends Serialisation {

    @Override
    public void apply(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            return;
        }
        response.setContentType("application/json;charset=UTF-8");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(request.getAttribute("listeClients"));

        out.println(json);

        out.close();
    }
}