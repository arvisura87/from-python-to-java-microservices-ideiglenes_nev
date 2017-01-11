package theme_service;

import theme_service.controller.ThemeController;

import java.net.URISyntaxException;
import static spark.Spark.*;


public class ThemeService {

    private ThemeController controller;

    public static void main(String[] args) {

        port(60001);

        ThemeService application = new ThemeService();

        application.controller = new ThemeController();

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
