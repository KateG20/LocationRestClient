package exceptions;

/**
 * Возникает при любых ошибках при работе определителя геолокации
 */
public class LocationDetectorException extends Exception {
    public LocationDetectorException(String message) {
        super(message);
    }
}
