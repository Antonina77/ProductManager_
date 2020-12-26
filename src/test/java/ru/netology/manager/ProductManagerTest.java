package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Сто лет одиночества", 450, "Габриэль Гарсиа Маркес");
    private Product second = new Book(2, "Ведьмак", 670, "Анджей Сапковский");
    private Product third = new Book(3, "Мартин Иден", 890, "Джек Лондон");
    private Product fourth = new Smartphone(4, "Zenfone 6", 34000, "ASUS");
    private Product fifth = new Smartphone(5, "Huawei P40 Pro", 57000, "Huawei");
    private Product sixth = new Smartphone(6, "Galaxy Note20", 46800, "Samsung");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SearchByExist.csv")
    void shouldSearchByExist(int index, String text) {
        assertEquals(repository.getAll()[index], manager.searchBy(text)[0]);
    }

    @Test
    void shouldSearchByNotExist() {
        assertArrayEquals(new Product[]{}, manager.searchBy("Xiaomi"));
    }
}