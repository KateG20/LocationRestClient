import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class LocationApp {
    public static void main(String[] args) {
        RestClient client = new RestClient();
        String info;

        try {
            info = client.getJsonInfo("https://freegeoip.app/json");
        } catch (IOException e) {
            System.out.println("Problems with reading data. Fix it and try again.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("URI is incorrect. Fix it and try again.");
            return;
        }

        LocationParser parser = new LocationParser();
        Location location;

        try {
            location = parser.parseFromJson(info);
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