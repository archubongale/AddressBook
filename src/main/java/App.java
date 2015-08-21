import java.util.*;

import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
   // get(/) type of route get this url..

    get ("/contacts", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("contacts", Contact.all());
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
    
    get("contacts/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/contact-form.vtl");
     return new ModelAndView(model, layout);
   }, new  VelocityTemplateEngine());

    post("/contacts", (request,response) -> { //correlates to template - .vtl (URL)
     HashMap<String, Object> model = new HashMap<String, Object>();
     String FirstName = request.queryParams("firstname");
     String LastName = request.queryParams("lastname");
     String Dob = request.queryParams("dob");
     Contact newContact = new Contact("firstname", "lastname", "dob");
     model.put("contact", newContact);
     model.put("template", "templates/success.vtl");
     return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

    get("/contacts/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();

     Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
     model.put("contact", contact);
     model.put("")
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


    
  }//end of main
}//end of class
