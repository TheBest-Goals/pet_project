package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.dto.ProductRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void createProduct_SSARP(){
        ProductRequestDto rdto = new ProductRequestDto();
        rdto.setName("100 robux");
        rdto.setPrice(500.0);
        rdto.setStock(10);
        rdto.setType("Game_currency");

        Product sproduct = new Product();
        sproduct.setId(1L);
        sproduct.setName("100 robux");
        sproduct.setPrice(500.0);
        sproduct.setStock(10);
        sproduct.setType("game_currency");

        when(productRepository.save(any(Product.class))).thenReturn(sproduct);

        Product result = productService.createProduct(rdto);

        assertNotNull(result,"product shouldn't be null" );
        assertEquals("100 robux", result.getName());
        verify(productRepository).save(any(Product.class));
    }
}
