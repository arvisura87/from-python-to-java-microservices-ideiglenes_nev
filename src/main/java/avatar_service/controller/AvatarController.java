package avatar_service.controller;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;


public class AvatarController {

    public String getAvatar(Request request, Response response){
        String sess = request.queryParams("sessionid");
        int sum = 0;
        for ( int i = 0; i < sess.length(); i++){
            sum += Character.getNumericValue(sess.charAt(i));
        }
        sum%=10;

        List<String> links = new ArrayList<>();
        links.add("goo.gl/4ZKXbh\n");
        links.add("goo.gl/jP8gDY\n");
        links.add("goo.gl/M1vDTh\n");
        links.add("goo.gl/SNXHjv\n");
        links.add("goo.gl/5pHsWy\n");
        links.add("goo.gl/uG3Q9Q\n");
        links.add("goo.gl/J64rRy\n");
        links.add("goo.gl/ggJGe6\n");
        links.add("goo.gl/r5kIJs\n");
        links.add("goo.gl/WyKrLI");

        return links.get(sum);
    }
}
