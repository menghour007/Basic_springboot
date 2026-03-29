package org.example.testing_15.service.Imp;

import org.example.testing_15.model.Product;
import org.example.testing_15.repository.ProductRepo;
import org.example.testing_15.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private ProductRepo productRepo;
    public ProductServiceImp(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
    @Override
    public Product addProduct(Product product) {
        productRepo.addProduct(product);
        return product;
    }
    @Override
    public Product getProduct(int id) {
        return productRepo.findById(id);
    }
//    @Override
//    public Product updateProduct(Product product) {
//        productRepo.updateProduct(product);
//        return product;
//    }
    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
    @Override
    public Product updateProduct(Integer id, Product product) {
        Product existingProduct = productRepo.findById(id);

        if (existingProduct == null) {
            return null;
        }

        product.setProductId(id);
        productRepo.updateProduct(product);
        return product;
    }
}
