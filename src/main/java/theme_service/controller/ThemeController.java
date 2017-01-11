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
        int actual = 4; // 11, 0, 1 --> Winter:1;   2, 3, 4 --> Spring:2;   5, 6, 7 --> Summer:3;   8, 9, 10 --> Autumn:4
        if ( month == 11 || month == 0 || month == 1 ){
            actual = 0;
        }
        else if (month == 2 || month == 3 || month == 4){
            actual = 1;
        }
        else if (month == 5 || month == 6 || month == 7){
            actual = 2;
        }
        else if (month == 8 || month == 9 || month == 10){
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
