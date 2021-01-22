package parser;

/**
 * Интерфейс json-парсера
 */
public interface JsonParser {
    /**
     * Достает объект из строки json-формата
     *
     * @param jsonString строка json-формата
     * @param clazz      Class-объект с нужным generic-типом
     * @param <T>        тип объекта, который парсим
     * @return объект типа T из джейсоновской строки
     */
    <T> T parseFromJson(String jsonString, Class<T> clazz);
}
