/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author magal
 */
public class CalcMethods {

    private static String apiKey = "AIzaSyC7pURgulX3H3tDr01QOBh62PAgLLlGmAE";


    private CalcMethods() {

    }

    public static double calcDistanceBetweenCoordinates(float lat1, float long1, float lat2, float long2) throws IOException {

        final int R = 6371; // raio da Terra

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(long2 - long1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // metros

        double height = Math.abs(calcPointElevation(lat1, long1) - calcPointElevation(lat2, long2));

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }


    public static double calcPointElevation(float latitude, float longitude) throws IOException {
        double elevation = 0;

        String url = "https://maps.googleapis.com/maps/api/elevation/json?locations=" + latitude + "," + longitude + "&key=" + apiKey;

        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        InputStream content = urlConnection.getInputStream();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(content, UTF_8));
        String line;
        String outString = "";
        while ((line = buffer.readLine()) != null) {
            outString += line;
        }

        String[] lineSplit = outString.split(",");

        elevation = Double.parseDouble(lineSplit[0].replaceAll("[^\\d.]", ""));

        return elevation;
    }

}