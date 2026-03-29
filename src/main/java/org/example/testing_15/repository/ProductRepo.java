package org.example.testing_15.repository;

import org.apache.ibatis.annotations.*;
import org.example.testing_15.model.Product;

import java.util.List;

@Mapper
public interface ProductRepo {
    @Select("""
        SELECT 
            product_id AS productId,
            product_name AS productName,
            price,
            category_id AS categoryId
        FROM products
    """)
    List<Product> findAll();

    @Select("""
    SELECT 
        product_id AS productId,
        product_name AS productName,
        price,
        category_id AS categoryId
    FROM products
    WHERE product_id = #{id}
    """)
    Product findById(Integer id);

    @Insert("""
    INSERT INTO products (product_name, price, category_id)
    VALUES (#{productName}, #{price}, #{categoryId})
""")
    @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
    void addProduct(Product product);

    @Update("""
        UPDATE products
        set product_name = #{productName}, price = #{price}, category_id = #{categoryId}
        where product_id = #{id}
""")
    void updateProduct(Product product);

    @Delete("""
        DELETE from products
        where product_id = {id}
    """)
    void deleteById(Integer id);
}
