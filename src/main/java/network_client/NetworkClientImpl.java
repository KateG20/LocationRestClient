package network_client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс для работы с сервером, реализующий интерфейс для работы с сервером
 */
public class NetworkClientImpl implements NetworkClient {
    /**
     * Достает данные get-запросом к указанному URI
     *
     * @param uri адрес сервера
     * @return строка с данными
     * @throws IOException при возникновении проблем при чтении данных
     */
    @Override
    public String getResponseString(String uri) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
