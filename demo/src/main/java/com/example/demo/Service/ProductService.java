package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductRequestDto;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> FindAll(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public boolean updateProduct(Long id, String newName, double newPrice, int newStock){
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            Product product = optional.get();
            product.setName(newName);
            product.setPrice(newPrice);
            product.setStock(newStock);

            productRepository.save(product);
            return true;
        }
        return false;
    }

    

    public boolean deleteProduct(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Product> findByStockGreaterThan(int stock){
        return productRepository.findByStockGreaterThan(stock);
    }
    public List<Product> findByNameContaining(String name){
            return productRepository.findByNameContaining(name);
    }

    public List<Product> findByPriceLessThanEqual(double price){
        return productRepository.findByPriceLessThanEqual(price);
    }

    public List<Product> findByStock(){
        return productRepository.findByStock(0);
    }

    public List<ProductDto> getALlProductsMarket(){
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductDto dto = new ProductDto();
                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setPrice(product.getPrice());
                    dto.setStock(product.getStock());
                    dto.setType((product.getType()));

                    if(product.getSeller() != null){
                        dto.setSellerId(product.getSeller().getId());
                        dto.setSellerName(product.getSeller().getUsername());
                    }
                    return dto;
                })
                .toList();
    }

    public void AddProductDto(ProductDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setType(dto.getType());

        productRepository.save(product);
    }

    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setType(product.getType());

        if (product.getSeller() != null) {
            dto.setSellerId(product.getSeller().getId());
            dto.setSellerName(product.getSeller().getUsername());
        }
        return dto;
    }

    public Product createProduct(ProductRequestDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

}