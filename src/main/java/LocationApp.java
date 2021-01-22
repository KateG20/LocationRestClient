import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class LocationApp {
    public static void main(String[] args) {
        NetworkClientImpl client = new NetworkClientImpl();
        String info;

        try {
            info = client.getResponseString("https://freegeoip.app/json");
        } catch (IOException e) {
            System.out.println("Problems with reading data. Fix it and try again.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("URI is incorrect. Fix it and try again.");
            return;
        }

        JsonParser parser = new JsonParser();
        Location location;

        try {
            location = parser.parseFromJson(info, Location.class);
        } catch (JsonSyntaxException e) {
            System.out.println("JSON is incorrect. Fix it and try again.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect numbers in JSON. Fix it and try again.");
            return;
        }

        System.out.println(location.toString());
    }
}