package parser;

import com.google.gson.JsonSyntaxException;
import entity.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserImplTest {

    @Test
    void test_parseFromJson_correctJson() {
        String jsonString = "{\"country_name\":\"Россия\",\"region_name\":\"Москва\",\"city\":\"Москва\"," +
                "\"latitude\":55.7527,\"longitude\":37.6172}";
        JsonParser parser = new JsonParserImpl();
        Location location = parser.parseFromJson(jsonString, Location.class);
        assertEquals("Россия", location.getCountryName());
        assertEquals("Москва", location.getRegionName());
        assertEquals("Москва", location.getCity());
        assertEquals(55.7527, location.getLatitude());
        assertEquals(37.6172, location.getLongitude());
    }

    @Test
    void test_parseFromJson_incompleteJsonWithoutNumber() {
        String jsonString = "{\"country_name\":\"Россия\",\"region_name\":\"Москва\",\"city\":\"Москва\"," +
                "\"latitude\":55.7527}";
        JsonParser parser = new JsonParserImpl();
        Location location = parser.parseFromJson(jsonString, Location.class);
        assertEquals("Россия", location.getCountryName());
        assertEquals("Москва", location.getRegionName());
        assertEquals("Москва", location.getCity());
        assertEquals(55.7527, location.getLatitude());
        assertThrows(NullPointerException.class, location::getLongitude);
    }

    @Test
    void test_parseFromJson_incompleteJsonWithoutString() {
        String jsonString = "{\"region_name\":\"Москва\",\"city\":\"Москва\"," +
                "\"latitude\":55.7527,\"longitude\":37.6172}";
        JsonParser parser = new JsonParserImpl();
        Location location = parser.parseFromJson(jsonString, Location.class);
        assertNull(location.getCountryName());
        assertEquals("Москва", location.getRegionName());
        assertEquals("Москва", location.getCity());
        assertEquals(55.7527, location.getLatitude());
        assertEquals(37.6172, location.getLongitude());
    }

    @Test
    void test_parseFromJson_brokenJson() {
        String jsonString = "{\"country_name\":\"Ро\"'':'5'5.7527,\"longitude\":37.6172}";
        JsonParser parser = new JsonParserImpl();
        assertThrows(JsonSyntaxException.class,
                () -> parser.parseFromJson(jsonString, Location.class));
    }

    @Test
    void test_parseFromJson_incorrectJson() {
        String jsonString = "{\"country_name\":\"Россия\",\"region_name\":\"Москва\",\"city\":\"Москва\"," +
                "\"latitude\":55.7527,\"longitude\":37.hjfdh6172}";
        JsonParser parser = new JsonParserImpl();
        assertThrows(NumberFormatException.class,
                () -> parser.parseFromJson(jsonString, Location.class));
    }
}