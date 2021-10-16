package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {



    @Test
    void shouldSearchByAll() {
        ProductRepository repository = new ProductRepository();
        Manager manager = new Manager(repository);
        Product book1 = new Book(1, "name1", 500, "author1");
        Product book2 = new Book(2, "name2", 600, "author2");
        Product book3 = new Book(3, "name3", 700, "author3");
       manager.add(book1);
       manager.add(book2);
       manager.add(book3);

      Product[] expected = manager.searchBy("author");
      Product[] actual = {book1, book2, book3};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByOne() {
        ProductRepository repository = new ProductRepository();
        Manager manager = new Manager(repository);
        Product book1 = new Book(1, "name1", 500, "author1");
        Product book2 = new Book(2, "name2", 600, "author2");
        Product book3 = new Book(3, "name3", 700, "author3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = manager.searchBy("author1");
        Product[] actual = {book1};
        assertArrayEquals(expected, actual);

    }
}