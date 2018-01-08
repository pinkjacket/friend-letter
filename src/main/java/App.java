

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public"); //this line has changed!

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "hello.hbs");
                }, new HandlebarsTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "favorite_photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "greeting_card.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
