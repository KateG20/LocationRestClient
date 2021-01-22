import com.google.gson.JsonSyntaxException;
import entity.Location;
import exceptions.LocationDetectorException;
import network_client.NetworkClient;
import parser.JsonParser;

import java.io.IOException;

/**
 * Класс определителя геолокации
 */
public class LocationDetector {
    NetworkClient client;
    JsonParser parser;

    public LocationDetector(NetworkClient client, JsonParser parser) {
        this.client = client;
        this.parser = parser;
    }

    /**
     * Добывает строковую информацию о метоположении по указанному URI
     *
     * @param uri адрес сервера
     * @return строковая информация о геолокации
     * @throws LocationDetectorException при возникновении проблем с извлечением данных
     */
    public String locate(String uri) throws LocationDetectorException {
        String fetchedDataString;

        // Достаем запарсенную строку по адресу
        try {
            fetchedDataString = client.getResponseString(uri);
        } catch (IOException e) {
            throw new LocationDetectorException("Problems with reading data. Fix it and try again.");
        } catch (IllegalArgumentException e) {
            throw new LocationDetectorException("URI is incorrect. Fix it and try again.");
        }

        fetchedDataString = "{\"ip\":\"176.14.190.172\",\"country_code\":\"RU\",\"country_name\":\"Россия\",\"region_code\":\"MOW\",\"region_name\":\"Москва\",\"city\":\"Москва\",\"zip_code\":\"125009\",\"time_zone\":\"Europe/Moscow\",\"latitude\":55.7527,\"metro_code\":0}";
        Location location;

        // Парсим ее в объект геолокации
        try {
            location = parser.parseFromJson(fetchedDataString, Location.class);
        } catch (JsonSyntaxException e) {
            throw new LocationDetectorException("JSON is incorrect. Fix it and try again.");
        } catch (NumberFormatException e) {
            throw new LocationDetectorException("Incorrect numbers in JSON. Fix it and try again.");
        } catch (IllegalArgumentException e) {
            throw new LocationDetectorException(e.getMessage());
        }

        return location.toString();
    }
}
