package org.example.testing_15.service;

import org.example.testing_15.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product addProduct(Product product);
    public Product getProduct(int id);
    public void deleteProduct(int id);

    Product updateProduct(Integer id, Product product);
}
