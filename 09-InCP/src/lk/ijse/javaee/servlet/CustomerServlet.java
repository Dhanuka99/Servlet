package lk.ijse.javaee.servlet;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customer")

public class CustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        JsonArray jsonValues = reader.readArray();
        for (JsonValue jsonValue: jsonValues) {
            JsonObject jsonObject = jsonValue.asJsonObject();
            String id = jsonObject.getString("id");
        }
    }


}
