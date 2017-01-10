package avatar_service.service;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;

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
    private static final String API_URL="http://im.ziffdavisinternational.com/ign_hu/screenshot/default/avatar2_ugmy.";

    private static AvatarAPIService INSTANCE;

    public static AvatarAPIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AvatarAPIService();
        }
        return INSTANCE;
    }

    public URI avatar(String id) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(API_URL+id);

        return builder.build();
    }

    private String execute(URI uri) throws IOException {
        return Request.Get(uri).execute().returnContent().asString();
    }

}
