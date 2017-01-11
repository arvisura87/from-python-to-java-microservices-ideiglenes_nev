package theme_service.controller;

import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ThemeController {

    public String getTheme(Request request, Response response) {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int actual = 3; // 11, 0, 1 --> Winter:0;   2, 3, 4 --> Spring:1;   5, 6, 7 --> Summer:2;   8, 9, 10 --> Autumn:3
        if ( month == 11 || month == 0 || month == 1 ){
            actual = 0;
        }
        else if (month>=2 && month<=4){
            actual = 1;
        }
        else if (month>=5 && month<=7){
            actual = 2;
        }
        else {
            actual = 3;
        }

        List<String> links = new ArrayList<>();
        links.add("https://bootswatch.com/superhero/bootstrap.min.css\n");
        links.add("https://bootswatch.com/lumen/bootstrap.min.css\n");
        links.add("https://bootswatch.com/cerulean/bootstrap.min.css\n");
        links.add("https://bootswatch.com/united/bootstrap.min.css");

        return links.get(actual);
    }
}
