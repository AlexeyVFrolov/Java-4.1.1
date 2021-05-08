package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();

    Book firstProduct = new Book(1, "Hyperion", 100, "Dan Simmons");
    Book secondProduct = new Book(2, "Echopraxia", 150, "Peter Watts");
    SmartPhone thirdProduct = new SmartPhone(3, "Simmens", 10, "Europe");
    SmartPhone forthProduct = new SmartPhone(4, "SuperPhone", 10, "Hyperion");

    @BeforeEach
    public void setUp() {
        productRepository.save(firstProduct);
        productRepository.save(secondProduct);
        productRepository.save(thirdProduct);
        productRepository.save(forthProduct);
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        Product[] expected = new Product[] {firstProduct, thirdProduct, forthProduct};

        productRepository.removeById(2);
        assertArrayEquals(expected, productRepository.findAll());
    }

    @Test
    public void shouldNotRemoveByIdIfNotExistsAndReport() {

        assertThrows(NotFoundException.class, () -> productRepository.removeById(5));
    }
}