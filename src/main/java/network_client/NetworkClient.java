package network_client;

import java.io.IOException;

/**
 * Интерфейс для работы с сервером
 */
public interface NetworkClient {
    /**
     * Достает данные get-запросом к указанному URI
     *
     * @param uri адрес сервера
     * @return строка с данными
     * @throws IOException при возникновении проблем при чтении данных
     */
    String getResponseString(String uri) throws IOException;
}
