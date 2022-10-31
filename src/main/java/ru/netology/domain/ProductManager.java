//1.возможность добавлять продукты в репозиторий - создать конструткор c параметром репозитория
//2.создать publiс void add(Product product) - метод добавлени репозитория
//3. создать метод поиска по тексту searchBy(String text),будет возвращать массив найденных товаров
//4.геттеры .сетторы
//5.создать метод matches для определения соответствия товара product запросу search
package ru.netology.domain;


public class ProductManager {
    protected ru.netology.repository.ProductRepository repository;  // поле типа репозиторий

    public ProductManager(ru.netology.repository.ProductRepository repository) { // конструктор с параметором репозитория
        this.repository = repository;
    }

    public void add(Product product) { // метод добавление товаров в репозиторий
        repository.add(product);
    }

    public Product[] getProduct() {
        Product[] all = repository.getProducts();
        return all;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;

    }

    // метод определения соответствия товара product запросу search
    // При проверке на соответствие запросу товару мы проверяем вхождение запроса в текст названия товара.
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
            // или же в одну строку  return product.getName().contains(search);
        }
    }
}