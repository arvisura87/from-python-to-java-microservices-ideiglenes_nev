package avatar_service.controller;

import avatar_service.service.AvatarAPIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jocc on 2017.01.09..
 */
public class AvatarController {

    private AvatarAPIService service;

    public AvatarController(AvatarAPIService service) {

        this.service=service;
    }

    public URI getAvatar(Request request, Response response) throws URISyntaxException, IOException {
        return service.avatar("jpg");
    }
}
