package avatar_service.controller;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      Tamás Jakab
 * @version     0.9
 */

public class AvatarController {

    /**
     * <p>The method adds the numbers of the numeric values of the session id characters and after it after the divison
     * with remainder based on the number from 0 to 9 it give a link of an avatar picture from a hashmap.</p>
     * @param request
     * @param response
     * @return String: a link of an avatar picture.
     */

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
