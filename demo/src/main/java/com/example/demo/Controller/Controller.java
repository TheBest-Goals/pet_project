package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import com.example.demo.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/products")
@RestController
public class Controller {

    private final ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showAll() {
        return productService.FindAll();
    }

    @GetMapping("/products/{id}")
    public String showProductByID(@PathVariable Long id) {
        Product FoundProduct = productService.getById(id);

        if (FoundProduct == null) {
            System.out.println("No product with id " + id + " found");
            return "product not found";
        }
        return "you choose:" + FoundProduct.getName();
    }

    @PostMapping("/products")
    public String createProduct(@RequestParam Long id, @RequestParam String name, @RequestParam double price, @RequestParam int stock, @RequestParam String type)
    {

        Product newProduct = new Product(name, id, price, stock, type);
        productService.addProduct(newProduct);
        return "you added product with id " + id;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDto dto) {
        productService.AddProductDto((dto));
        return ResponseEntity.ok("you added product with id " + dto.getId());
    }

    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String newName, @RequestParam double newPrice, @RequestParam int newStock){
        boolean isUpdated = productService.updateProduct(id, newName, newPrice, newStock);
        if (isUpdated){
            return"towar c  ID " + id + "uspeshno dobavlen" + newName;
        }else{
            return " kosyak" + id + "nety takogo";
        }
    }

    @DeleteMapping("/products/{id}")
    public String deleteproduct(@PathVariable Long id) { // Используем Integer для полной гармонии с сервисом
        boolean isdeleted = productService.deleteProduct(id);
        if (isdeleted) {
            return "Product with ID " + id + " was successfully deleted";
        } else {
            return "kosyak, product wasn't deleted " + id;
        }
    }

    @GetMapping("/products/greater")
    public List<Product> greater(@RequestParam int stock){
        return productService.findByStockGreaterThan(stock);
    }


    @GetMapping("/products/containing")
    public List<Product> containing(@RequestParam String name){
        return productService.findByNameContaining(name);
    }

    @GetMapping("/products/lessThan")
    public List<Product> lessThan(@RequestParam double price){
        return productService.findByPriceLessThanEqual(price);
    }

    @GetMapping("/products/stock")
    public List<Product> stock(){
        return productService.findByStock();
    }

    @GetMapping("/market")
    public ResponseEntity<List<ProductDto>> getAllProductMarker(){
        List<ProductDto> products = productService.getALlProductsMarket();
        return ResponseEntity.ok(products);
    }

}