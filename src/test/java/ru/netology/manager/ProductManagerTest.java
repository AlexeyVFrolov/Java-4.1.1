package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager manager = new ProductManager();

    Book firstProduct = new Book (1, "Hyperion", 100, "Dan Simmons");
    Book secondProduct = new Book (2, "Echopraxia", 150, "Peter Watts");
    SmartPhone thirdProduct = new SmartPhone (3, "Simmens", 10, "Europe");
    SmartPhone forthProduct = new SmartPhone (4, "SuperPhone", 10, "Hyperion");

    @BeforeEach
    public void setUp() {
        manager.addProduct(firstProduct);
        manager.addProduct(secondProduct);
        manager.addProduct(thirdProduct);
        manager.addProduct(forthProduct);
    }

    @Test
    public void shouldSearchBooksByAndFindIfExists(){
        Product[] expected = new Product[] {firstProduct};

        assertArrayEquals(expected, manager.searchBy("Dan Simmons"));
    }

    @Test
    public void shouldSearchBooksByAndNotFindIfNotExists(){
        Product[] expected = new Product[0];

        assertArrayEquals(expected, manager.searchBy("Stephenson"));
    }

    @Test
    public void shouldSearchSmartPhonesByAndFindIfExists(){
        Product[] expected = new Product[] {thirdProduct};

        assertArrayEquals(expected, manager.searchBy("Simmens"));
    }

    @Test
    public void shouldSearchSmartPhonesByAndNotFindIfNotExists(){
        Product[] expected = new Product[0];

        assertArrayEquals(expected, manager.searchBy("Nokia"));
    }

    @Test
    public void shouldSearchByAndFindAllIfSeveral(){
        Product[] expected = new Product[] {firstProduct, forthProduct};

        assertArrayEquals(expected, manager.searchBy("Hyperion"));
    }

}