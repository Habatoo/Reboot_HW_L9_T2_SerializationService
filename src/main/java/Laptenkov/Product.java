package Laptenkov;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс {@link Product} характеризует объект - продовольственные продукт
 * Методы:
 *  public String serializeProductAsJSON(Product product) throws Exception;
 *
 * public Product deserializeProductFromJSON(String str) throws Exception;
 */
public class Product {
    /**
     * Поля {@link Product} :
     * - id
     * - название
     * - описание
     * - срок годности
     * - производитель
     * - List<String> штрихкоды
     */
    private int id;
    private String name;
    private String description;
    private String expirationDate;
    private String manufacturer;
    private List<String> barcodes;

    /**
     * Конструктор объекта {@link Product} без параметров.
     */
    public Product() {
    }

    /**
     * Конструктор объекта {@link Product} со всеми параметрами.
     */
    public Product(int id, String name, String description, String expirationDate, String manufacturer, List<String> barcodes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.barcodes = barcodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<String> barcodes) {
        this.barcodes = barcodes;
    }

    /**
     * Метод {@link Product#serializeProductAsJSON} определяет сигнатуру метода
     * для сериализации объекта типа JSON.
     * @param product объект типа {@link Product}
     * @return строковое представление объекта {@link Product}
     * @throws Exception
     */
    public String serializeProductAsJSON(Product product) throws Exception {
        return null;
    }

    /**
     * Метод {@link Product#serializeProductAsJSON} определяет сигнатуру метода
     * для десериализации объекта типа JSON.
     * @param str строковое представление объекта {@link Product}
     * @return объект типа {@link Product}
     * @throws Exception
     */
    public Product deserializeProductFromJSON(String str) throws Exception {
        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", barcodes=" + barcodes +
                '}';
    }
}