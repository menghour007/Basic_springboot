package org.example.testing_15.controller;

import org.apache.ibatis.annotations.Delete;
import org.example.testing_15.model.ApiResponse;
import org.example.testing_15.model.Product;
import org.example.testing_15.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Api/V1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {

        List<Product> products = productService.getProducts();

        ApiResponse<List<Product>> response = new ApiResponse<>(
                true,
                "Products fetch successfully",
                products
        );

        return ResponseEntity.ok(response);
    }
    @PostMapping("add")
    public ResponseEntity<ApiResponse<Product>> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        ApiResponse<Product> response = new ApiResponse<>(
                true,
                "Product add Successfull",
                savedProduct
        );
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProduct(@PathVariable Integer id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Product not found",
                    null
            ));

        }
        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product {id} fetch successfully",
                product
        ));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product updateProduct = productService.updateProduct(id,product);
        if (updateProduct == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    true,
                    "Product not found",
                    null
            ));
        }
        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product update succefully",
                updateProduct
        ));
    }
    @Delete("/{id}")
    public ResponseEntity<ApiResponse<Product>> deleteProduct(@PathVariable Integer id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Product not found",
                    null
            ));
        }
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product deleted successfully.",
                product
        ));
    }
}
