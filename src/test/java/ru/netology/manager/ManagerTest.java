package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Manager bookManager = new Manager(repository);
    private Manager smartphoneManager = new Manager(repository);
    private Manager productManager = new Manager(repository);
    private Product book1 = new Book(1, "name1", 500, "author1");
    private Product book2 = new Book(2, "name2", 600, "author2");
    private Product book3 = new Book(3, "name3", 700, "author3");
    private Product smartphone1 = new Smartphone(4, "iphone", 10000, "apple");
    private Product smartphone2 = new Smartphone(5, "galaxy", 10000, "samsung");
    private Product smartphone3 = new Smartphone(6, "eleven", 8000, "xiaomi");

    @BeforeEach
    public void setUp() {
        bookManager.add(book1);
        bookManager.add(book2);
        bookManager.add(book3);
        smartphoneManager.add(smartphone1);
        smartphoneManager.add(smartphone2);
        smartphoneManager.add(smartphone3);
    }


    @Test
    void shouldSearchBookByAuthorOne() {
        Product[] expected = bookManager.searchBy("author1");
        Product[] actual = {book1};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBookByNameOne() {
        Product[] expected = bookManager.searchBy("name1");
        Product[] actual = {book1};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = smartphoneManager.searchBy("iphone");
        Product[] actual = {smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        Product[] expected = smartphoneManager.searchBy("samsung");
        Product[] actual = {smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneBy() {
        Product[] expected = smartphoneManager.searchBy("nokia");
        Product[] actual = {};
        assertArrayEquals(expected, actual);
    }

}

