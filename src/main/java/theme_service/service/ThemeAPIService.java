package theme_service.service;

import org.apache.http.client.fluent.Request;
import theme_service.ThemeService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ThemeAPIService {

    private static ThemeAPIService INSTANCE;
    private static ThemeService service;

    public static ThemeAPIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThemeAPIService();
        }
        return INSTANCE;
    }

    public String theme(int id) throws URISyntaxException {

        return service.links.get(id);
    }

    private String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }
}
