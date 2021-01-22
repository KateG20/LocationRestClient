import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class LocationParser {
    public Location parseFromJson(String jsonString) {
        if (jsonString == null) {
            throw new IllegalArgumentException("Empty JSON");
        }

        Gson g = new Gson();
        Location location = new Location();
//        try {
            location = g.fromJson(String.valueOf(jsonString), Location.class);
//        }
//        catch (JsonSyntaxException e) {
//            // TODO
//        }

        return location;
    }
}
