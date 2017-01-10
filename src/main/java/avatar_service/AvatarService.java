package avatar_service;

import avatar_service.controller.AvatarController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

import static spark.Spark.*;

/**
 * Created by jocc on 2017.01.09..
 */
public class AvatarService {
    private static final Logger logger = LoggerFactory.getLogger(AvatarService.class);


    public static void main(String[] args) {

        setup(args);

        AvatarController controller = new AvatarController();

        // --- MAPPINGS ---
        get("/status", controller::status);
//        get("/api/random", controller::random);
//        get("/api/categories", controller::categories);

        // --- EXCEPTION HANDLING ---
        exception(URISyntaxException.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("URI building error, maybe wrong format? : %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
            logger.error("Error while processing request", exception);
        });
    }

    /**
     * Setting up port
     * @param args - app args
     */
    private static void setup(String[] args){
        if(args == null || args.length == 0){
            logger.error("Port must be given as the first argument.");
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e){
            logger.error("Invalid port given '{}', it should be number.", args[0]);
            System.exit(-1);
        }
    }
}
