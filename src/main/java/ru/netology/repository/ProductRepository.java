//1.создать репозиторий с полем массива товаров Product []
//2.возможность сохранять Product ы
//3.показывать Product ы
//4.удалять товар по id
//5. добавить геттер для items


//6. создать метод findById
//7. вызвать метод findById в removeById


package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;


public class ProductRepository {
    private Product[] products = new Product[0];


    public Product[] getProducts() {
        return products;
    }


    public Product[] getItems() {
        return products;
    }


    // сохраняем товар
    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];// создадим новую линию массива
        // перебираем и фиксируем в новый массив тмп
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;// создаем ячейку в массиве для последней переменной
        products = tmp;
    }


    //показываем весь товар
    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) { // перебираем и сверяем есть ли такой id.при отсутствие возвращем null
                return product;
            }
        }
        return null;
    }

    //удаление по id
    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(

                    "Element with id: " + id + " not found"
            );
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
        return products;
    }


}
