package avatar_service;

import avatar_service.controller.AvatarController;
import avatar_service.service.AvatarAPIService;

import java.net.URISyntaxException;

import static spark.Spark.*;

/**
 * Created by jocc on 2017.01.09..
 */
public class AvatarService {
    private AvatarController controller;

    public static void main(String[] args) {

        port(60000);

        AvatarService application = new AvatarService();

        application.controller = new AvatarController(AvatarAPIService.getInstance());


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
