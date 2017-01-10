package theme_service.controller;

import theme_service.service.ThemeAPIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;


public class ThemeController {

    private ThemeAPIService service;

    public ThemeController(ThemeAPIService service) {

        this.service=service;
    }

    public String getTheme(Request request, Response response) throws URISyntaxException, IOException {
        return service.theme(1);
    }
}
