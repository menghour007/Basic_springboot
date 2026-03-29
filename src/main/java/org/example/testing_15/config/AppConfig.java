package org.example.testing_15.config;

import org.example.testing_15.repository.ProductRepo;
import org.example.testing_15.service.Imp.ProductServiceImp;
import org.example.testing_15.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductService productService(ProductRepo productRepo) {
        return new ProductServiceImp(productRepo);
    }
}
