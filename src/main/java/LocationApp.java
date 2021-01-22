import exceptions.LocationDetectorException;
import network_client.NetworkClientImpl;
import parser.JsonParserImpl;

public class LocationApp {
    /**
     * Точка входа в программу
     * @param args аргументы КС
     */
    public static void main(String[] args) {
        // Создаем объект детектора
        LocationDetector detector = new LocationDetector(new NetworkClientImpl(), new JsonParserImpl());

        // Определяем геолокацию
        String myLocation;
        try {
            myLocation = detector.locate("https://freegeoip.app/json");
        } catch (LocationDetectorException e) {
            e.printStackTrace();
            return;
        }

        // Печатаем
        System.out.println(myLocation);
    }
}