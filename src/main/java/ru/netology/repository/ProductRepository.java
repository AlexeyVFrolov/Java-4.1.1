package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product newProduct) {
        Product[] tmp = new Product[products.length + 1];

        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        boolean isProductToRemove = false;

        for (Product product : products) {
            if (product.getId() == id) isProductToRemove = true;
        }
        if (!isProductToRemove) throw new NotFoundException("Element with id: \" + id + \" not found");
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        // меняем наши элементы
        products = tmp;

    }

    public void removeAll(){
        products = new Product[0];
    }

}
