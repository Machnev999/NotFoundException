package ru.netology.domain;

import ru.netology.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepositoryTest {
    Product item1 = new Book(1, "Книга 1", 1_000, "Автор 1");
    Product item2 = new Book(2, "Книга 2", 2_000, "Автор 2");
    Product item3 = new Smartphone(3, "Телефон 1", 10_000, "Марка 1");
    Product item4 = new Smartphone(4, "Телефон 2", 20_000, "Марка 2");
    Product item5 = new Smartphone(5, "Телефон 3", 30_000, "Марка 3");


    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldSave() {
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        repository.add(item5);
        Product[] expected = {item1, item2, item3, item4, item5};
        assertArrayEquals(expected, repository.findAll());

    }


    @Test
    public void shouldRemove() {
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        repository.add(item5);
        repository.removeById(item3.getId());
        Product[] expected = {item1, item2, item4, item5};
        assertArrayEquals(expected, repository.getItems());
    }
}