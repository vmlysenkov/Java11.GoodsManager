package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class Manager {
    private ProductRepository repository;

    public Manager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] results = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[results.length + 1];
                System.arraycopy(results, 0, tmp, 0, results.length);
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                tmp[tmp.length - 1] = product;
                results = tmp;
            }
        }
        return results;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положим его в переменную типа Book, чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }

}


