package Controller;

import Model.Order;
import Service.OrderService;
import org.springframework.web.bind.annotation.*;

import Service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order orderInfo) {
        return orderService.createOrder(orderInfo);
    }

    @DeleteMapping("/orders/{id}")
    public boolean deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }

    @PutMapping("/orders/{id}")
    public boolean updateOrder(@PathVariable int id, @RequestBody Order newOrderData) {
        return orderService.updateOrder(id, newOrderData);
    }
}