package utils;

import entities.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Extension {

    public static List<Movie> sortedList = new ArrayList<>();

    public static LocalDate parseDate(String date) {
        String[] ss = date.split("/");
        int year = 0;
        int month = 0;
        int day = 0;
        for (int i = ss.length - 1; i > -1; i--) {
            if (i == 0)
                month = Integer.parseInt(ss[i]);
            else if (i == 1)
                day = Integer.parseInt(ss[i]);
            else {
                if (ss[i].length() != 4) {
                    year = Integer.parseInt("19" + ss[i]);
                } else {
                    year = Integer.parseInt(ss[i]);
                }
            }
        }
        LocalDate dt = LocalDate.of(year, month, day);
        return dt;
    }
    public static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void getDataBasedOnRange(List<Crash> list) throws IOException {
        if (list == null || list.size() != 0) {
            System.out.println("Please, write range  (ex: 5 100)");
            String from = "";
            String to = "";
            while (true) {
                System.out.println("From: ex( 5 )");
                from = reader.readLine();
                System.out.println("To: ex( 100 )");
                to = reader.readLine();
                if (Extension.checkSelectedNumber(from) && Extension.checkSelectedNumber(to)) {
                    if ((Integer.parseInt(from) <= Integer.parseInt(to) && Integer.parseInt(from) > 0)) {
                        Extension.sortedList = list.stream().skip(Integer.parseInt(from) - 1).limit(Integer.parseInt(to) - Integer.parseInt(from) + 1).collect(Collectors.toList());
                         Extension.sortedList
                                .forEach(w -> {
                                    System.out.println(w.toString());
                                });
                        break;
                    } else {
                        System.out.println("Please, enter correct range");
                    }
                } else {
                    System.out.println("Please, enter only digit");
                }
            }
        }
    }

}
