package web.vue;

public class RepartitionClientSerialisation extends Serialisation {
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
        String json = gson.toJson(request.getAttribute("repartitionClients"));

        out.println(json);

        out.close();
    }
}