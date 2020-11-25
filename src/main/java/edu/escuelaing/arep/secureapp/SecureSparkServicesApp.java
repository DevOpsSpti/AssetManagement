package edu.escuelaing.arep.secureapp;
import com.google.gson.Gson;
import edu.escuelaing.arep.secureapp.entities.User;
import edu.escuelaing.arep.secureapp.service.CifrateService;
import edu.escuelaing.arep.secureapp.service.UserService;
import spark.staticfiles.StaticFilesConfiguration;
import java.util.Map;

import static spark.Spark.*;

/**
 * The type Secure spark services app.
 */
public class SecureSparkServicesApp {
    private static UserService us = new UserService();
    private static Map<String,String> users = us.getUsers();
    /**
     * The constant cifrate.
     */
    public static CifrateService  cifrate = new CifrateService();

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String ... args){
        port(getPort());
        secure("keystores/ecikeystore.p12", "pansito", null,null);
        HttpsClient.init();
        before("secure/*",(req,res)->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("AUTHORIZED",false);
            }
            boolean auth=req.session().attribute("AUTHORIZED");
            if(!auth){
                halt(401,"<h1> Nothing to see here bye :).</h1>");
            }
        });
        before("/login.html",(req,res) ->{
            req.session(true);
            if(req.session().isNew()){
                req.session().attribute("AUTHORIZED",false);
            }
            if(req.session().attribute("AUTHORIZED")){
                res.redirect("secure/index.html");
            }
        });
        StaticFilesConfiguration staticHandler = new StaticFilesConfiguration();
        staticHandler.configure("/");
        before((req, res) ->
                staticHandler.consume(req.raw(), res.raw()));
        get("/", (req, res) -> {
            res.redirect("/login.html");
            return "ok";
        });
        get("/hello", ((request, response) -> {
            return HttpsClient.getServerInfo();
        }));
        get("secure/usr",(req,res)->{
            return req.session().attribute("usr");
        });
        post("/login",(req,res) ->{
            req.session(true);
            Gson gson = new Gson();
            User user = gson.fromJson(req.body(),User.class);
            if(cifrate.cifrateSHA1(user.getPassword()).equals(us.getPassByUser(user.getUsername()))){
                req.session().attribute("usr",user.getUsername());
                req.session().attribute("AUTHORIZED",true);
                res.redirect("secure/index.html");
            }
            else{
                return "Error en la autentificación";
            }return "";
        });

    }

    /**
     * Gets port.
     *
     * @return the port
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
