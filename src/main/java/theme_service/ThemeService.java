package theme_service;

import theme_service.controller.ThemeController;
import theme_service.service.ThemeAPIService;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;


public class ThemeService {

    private ThemeController controller;
    public static final List<String> links = new ArrayList<>();


    public static void main(String[] args) {

        port(60001);

        ThemeService application = new ThemeService();

        application.controller = new ThemeController(ThemeAPIService.getInstance());

        links.add("winter\n");
        links.add("spring\n");
        links.add("summer\n");
        links.add("autumn");

        // --- MAPPINGS ---
        get("/theme", application.controller::getTheme);

        // --- EXCEPTION HANDLING ---
        exception(URISyntaxException.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("URI building error, maybe wrong format? : %s", exception.getMessage()));
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
        });
    }

    /**
     * Setting up port
     * @param args - app args
     */
    private static void setup(String[] args){
        if(args == null || args.length == 0){
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e){
            System.exit(-1);
        }
    }
}
