package avatar_service.controller;

import avatar_service.service.AvatarAPIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;


public class AvatarController {

    private AvatarAPIService service;

    public AvatarController(AvatarAPIService service) {

        this.service=service;
    }

    public String getAvatar(Request request, Response response) throws URISyntaxException, IOException {
        String sess = request.session().id();
        int sum = 0;
        for ( int i = 0; i < sess.length(); i++){
            sum += Character.getNumericValue(sess.charAt(i));
        }
        sum%=10;

        return service.avatar(sum);
    }
}
