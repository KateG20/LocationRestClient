package parser;

import com.google.gson.Gson;

/**
 * Класс json-парсера, реализующий интерфейс json-парсера (обоже)
 */
public class JsonParserImpl implements JsonParser {
    /**
     * Достает объект из строки json-формата
     *
     * @param jsonString строка json-формата
     * @param clazz      Class-объект с нужным generic-типом
     * @param <T>        тип объекта, который парсим
     * @return объект типа T из джейсоновской строки
     */
    @Override
    public <T> T parseFromJson(String jsonString, Class<T> clazz) {
        if (jsonString == null) {
            throw new IllegalArgumentException("Empty JSON. Fix it and try again.");
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }
}
