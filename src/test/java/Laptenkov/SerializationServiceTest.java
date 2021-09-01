package Laptenkov;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для тестирования объектов {@link SerializationService}.
 */
class SerializationServiceTest {

    Product productEmpty;
    Product productNotEmpty;
    List<String> barcodes;
    SerializationService serializationService;
    String emptyString;
    String notEmptyString;

    /**
     * Инициализация объектов для тестированияния {@link SerializationService}.
     */
    @BeforeEach
    void setUp() {
        productEmpty = new Product();

        barcodes = new ArrayList<>();
        barcodes.add("OOOOO-PPPPP-MMMM");
        barcodes.add("MMMM-PPPPP-MMMM");
        barcodes.add("OOOOO-OOOOO-MMMM");
        productNotEmpty = new Product(
                10,
                "Test name",
                "Test description",
                "2021-02-01",
                "Test developer",
                barcodes);

        emptyString = "{\"id\":0,\"name\":null,\"description\":null,\"expirationDate\":null,\"manufacturer" +
                "\":null,\"barcodes\":null}";
        notEmptyString = "{\"id\":10,\"name\":\"Test name\",\"description\":\"Test description\",\"expirationDate" +
                "\":\"2021-02-01\",\"manufacturer\":\"Test developer\",\"barcodes\":[\"OOOOO-PPPPP-MMMM\"," +
                "\"MMMM-PPPPP-MMMM\",\"OOOOO-OOOOO-MMMM\"}";

        serializationService = new SerializationService();
    }

    /**
     * Очистка объектов после тестированияния {@link SerializationService}.
     */
    @AfterEach
    void tearDown() {
        productEmpty = null;
        productNotEmpty = null;
        barcodes = null;
        serializationService = null;
        emptyString = null;
        notEmptyString = null;

    }

    /**
     * Метод {@link SerializationServiceTest#serializeProductAsJSONSuccess_Test}
     * проверяет метод {@link SerializationService#serializeProductAsJSON}.
     *
     * Сценарий возвращает <code>true</code> при успешной сериализации
     */
    @Test
    void serializeProductAsJSONSuccess_Test() throws Exception {
        Assert.assertEquals(
                emptyString, serializationService.serializeProductAsJSON(productEmpty));
        Assert.assertEquals(notEmptyString, serializationService.serializeProductAsJSON(productNotEmpty));
    }

    /**
     * Метод {@link SerializationServiceTest#deserializeProductFromJSONSuccess_Test}
     * проверяет метод {@link SerializationService#serializeProductAsJSON}.
     *
     * Сценарий возвращает <code>true</code> при успешной десериализации
     */
    @Test
    void deserializeProductFromJSONSuccess_Test() throws Exception {
        Assert.assertEquals(
                productEmpty.getId(),
                serializationService.deserializeProductFromJSON(emptyString).getId());
        Assert.assertEquals(
                productEmpty.getName(),
                serializationService.deserializeProductFromJSON(emptyString).getName());
        Assert.assertEquals(
                productEmpty.getDescription(),
                serializationService.deserializeProductFromJSON(emptyString).getDescription());
        Assert.assertEquals(
                productEmpty.getExpirationDate(),
                serializationService.deserializeProductFromJSON(emptyString).getExpirationDate());
        Assert.assertEquals(
                productEmpty.getManufacturer(),
                serializationService.deserializeProductFromJSON(emptyString).getManufacturer());
        Assert.assertEquals(
                productEmpty.getBarcodes(),
                serializationService.deserializeProductFromJSON(emptyString).getBarcodes());
    }

    /**
     * Метод {@link SerializationServiceTest#deserializeProductFromJSONFail_Test}
     * проверяет метод {@link SerializationService#serializeProductAsJSON}.
     *
     * Сценарий возвращает <code>false</code> при не успешной десериализации
     * JAXBException если сериализация не удалась.
     */
    @Test
    void deserializeProductFromJSONFail_Test() {
        Throwable throwable = Assertions.assertThrows(
                Exception.class, () -> serializationService.deserializeProductFromJSON(""));
        Assertions.assertEquals("No content to map due to end-of-input\n" +
                " at [Source: (String)\"\"; line: 1, column: 0]", throwable.getMessage());
    }

}