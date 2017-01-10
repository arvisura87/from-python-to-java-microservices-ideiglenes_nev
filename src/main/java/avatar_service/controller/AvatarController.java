package avatar_service.controller;

import avatar_service.service.AvatarAPIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Created by jocc on 2017.01.09..
 */
public class AvatarController {

    private AvatarAPIService service;

    public AvatarController(AvatarAPIService service) {

        this.service=service;
    }

    public String getAvatar(Request request, Response response) throws URISyntaxException, IOException {
//        String sess = request.session().id();
//        int first = Character.getNumericValue(sess.charAt(0));
//        int r = (int) first;
//        while (r > 9)
//        {
//            r = r / 10;
//        }
        int result;
        if (request.session().attribute("rnNr") == null) {
            Random r = new Random();
            int low = 0;
            int high = 10;
            result = r.nextInt(high-low) + low;
            request.session().attribute("rnNr", result);
        } else {
            result = request.session().attribute("rnNr");
        }
        return service.avatar(result);
    }
}
