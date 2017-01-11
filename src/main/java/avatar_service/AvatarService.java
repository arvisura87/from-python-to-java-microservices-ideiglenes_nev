package avatar_service;

import avatar_service.controller.AvatarController;

import java.net.URISyntaxException;

import static spark.Spark.*;


public class AvatarService {
    private AvatarController controller;

    public static void main(String[] args) {

        port(60000);

        AvatarService application = new AvatarService();

        application.controller = new AvatarController();

        // --- MAPPINGS ---
        get("/avatar", application.controller::getAvatar);

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
