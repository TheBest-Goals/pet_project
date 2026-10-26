package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStockGreaterThan(int stock);

    List<Product> findByNameContaining(String name);

    List<Product> findByPriceLessThanEqual(double price );

    List<Product> findByStock(int stock);
}
