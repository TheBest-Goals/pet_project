package com.example.demo.Controller;


import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import com.example.demo.dto.OrderRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders") // короче это отдел(направление http://localhost:8080/api/orders)
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/buy") //это уже внутри отдела кабинет (http://localhost:8080/api/orders/buy)
    public ResponseEntity<String> buyItem(@Valid @RequestBody OrderRequestDto requestDto) {

        //ResponseEntity это ответ через HTTP вто есть выводит на сайт если ошибка то ошибка если успех то успех  короче типо принт

        try{
            orderService.buyItem(
                    requestDto.getUserId(),
                    requestDto.getItemId(),
                    requestDto.getQuantity()
            );
            return ResponseEntity.ok(" parchase completed successfully");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error while purchasing"+ e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity <List<Order>> getOrders(){
        List<Order> orders = orderService.getOrder();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/total{userid}")
    public double getTotalSpent(@PathVariable Long userId){
        return orderService.getTotalCost(userId);
    }
}
