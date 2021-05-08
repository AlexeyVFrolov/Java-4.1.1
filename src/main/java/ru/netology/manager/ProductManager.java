package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.SmartPhone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public void addProduct(Product newProduct) {
        repository.save(newProduct);
    }

    public Product[] searchBy(String searchString) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (product.matches(searchString)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
