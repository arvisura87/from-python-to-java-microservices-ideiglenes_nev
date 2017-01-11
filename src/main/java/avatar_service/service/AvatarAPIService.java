package avatar_service.service;

import avatar_service.AvatarService;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class AvatarAPIService {

    private static AvatarAPIService INSTANCE;
    private static AvatarService service;

    public static AvatarAPIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AvatarAPIService();
        }
        return INSTANCE;
    }

    public String avatar(int id) throws URISyntaxException {
//        URIBuilder builder = new URIBuilder(service.links.get(id));

//        return builder.build();
        return service.links.get(id);
    }

    private String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}
