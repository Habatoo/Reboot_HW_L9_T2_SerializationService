package Laptenkov;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Класс SerializationService,
 * обеспечивает сериализацию и десериализацию объектов Product в JSON
 *
 * Для сериализации / десериализации в JSON использовать класс ObjectMapper
 * Для сериализации / десериализации в XML использовать класс JAXBContext
 */
public class SerializationService {

    /**
     * Метод {@link SerializationService#serializeProductAsJSON} определяет метод
     * для сериализации объекта типа {@link Product} в формат JSON.
     * @param product объект типа {@link Product}
     * @return строковое представление объекта {@link Product}
     * @throws Exception если сериализация не удалась.
     */
    public String serializeProductAsJSON(Product product) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(product);

        return result;
    }

    /**
     * Метод {@link SerializationService#serializeProductAsJSON} определяет метод
     * для десериализации строкового объекта типа JSON в орбъект {@link Product}.
     * @param str строковое представление объекта {@link Product}
     * @return объект типа {@link Product}
     * @throws Exception если десериализации не удалась.
     */
    public Product deserializeProductFromJSON(String str) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(str, Product.class);

        return product;
    }
}