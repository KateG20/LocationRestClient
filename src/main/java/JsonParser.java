import com.google.gson.Gson;

public class JsonParser {
    public <T> T parseFromJson(String jsonString, Class<T> clazz) {
        if (jsonString == null) {
            throw new IllegalArgumentException("Empty JSON");
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }
}
