package Service;

import Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import Repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.orElseGet(Order::new);
    }

    public Order createOrder(Order orderInfo) {
        return orderRepository.save(orderInfo);
    }

    public boolean deleteOrder(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateOrder(int id, Order newOrderData) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setAmount(newOrderData.getAmount());
            order.setCustomerId(newOrderData.getCustomerId());
            order.setTotalPrice(newOrderData.getTotalPrice());
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}
