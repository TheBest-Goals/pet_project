    package com.example.demo.Service;

    import com.example.demo.Model.Order;
    import com.example.demo.Model.Product;
    import com.example.demo.Model.User;
    import com.example.demo.Repository.OrderRepository;
    import com.example.demo.Repository.ProductRepository;
    import com.example.demo.Repository.UserRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;

    @Service
    public class OrderService {

       private final OrderRepository oRepository;
       private final UserRepository uRepository;
       private final ProductRepository productRepository;

       public OrderService(OrderRepository oRepository, UserRepository uRepository, ProductRepository productRepository){
           this.oRepository = oRepository;
           this.uRepository = uRepository;
           this.productRepository = productRepository;
       }

        @Transactional
        public void buyItem(Long userId, Long itemId, int quantity){

            User user = uRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

            Product item = productRepository.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemId));

            if(item.getStock() < quantity){
                throw new RuntimeException("Not enough stock!");
            }

            double totalcost = item.getPrice() * quantity;
            if(totalcost > user.getBalance()){
                throw new RuntimeException("Not enough balance. Cost: " + totalcost + ", Your balance: " + user.getBalance());
            }

            item.setStock(item.getStock() - quantity);
            user.setBalance(user.getBalance() - totalcost);

            productRepository.save(item);
            uRepository.save(user);

            Order order = new Order(user, item, quantity, totalcost, LocalDateTime.now());
            oRepository.save(order);
        }

        public List<Order> getOrder(){
            return oRepository.findAll();
        }

        public double getTotalCost(Long userId){
            return oRepository.findAll().stream()
                    .filter(order -> order.getUser().getId().equals(userId))
                    .mapToDouble(Order::getTotalamount)
                    .sum();
        }
    }