package avatar_service.service;

import avatar_service.AvatarService;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jakab on 2017.01.10..
 */
public class AvatarAPIService {

    /*
     example link
     */
//    private static final String API_URL="http://im.ziffdavisinternational.com/ign_hu/screenshot/default/avatar2_ugmy.jpg";
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
