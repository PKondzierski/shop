package pl.kondzierski.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.kondzierski.shop.model.User;
import pl.kondzierski.shop.model.order.Order;
import pl.kondzierski.shop.model.order.OrderRow;
import pl.kondzierski.shop.model.order.Status;
import pl.kondzierski.shop.model.product.Product;
import pl.kondzierski.shop.model.security.LoginCredentials;
import pl.kondzierski.shop.repository.OrderRepository;
import pl.kondzierski.shop.repository.ProductRepository;
import pl.kondzierski.shop.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    OrderRepository orderRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<String> addOrder(Order order, Authentication user) {
        order.setStatus(Status.AWAITING_PAYMENT);
        Optional<User> userFound = userRepository.findByUsername(user.getPrincipal().toString());
        if (userFound.isEmpty())
            return new ResponseEntity<>("Użytkownik nie istnieje", HttpStatus.UNAUTHORIZED);
        order.setUser(userFound.get());
        BigDecimal bigDecimal = new BigDecimal(0);
        order.getOrderRows().forEach((orderRow) -> {
            Product myProduct = productRepository.findMyProduct(orderRow.getProduct().getId());
            orderRow.setProduct(myProduct);
            orderRow.setPrice(myProduct.getRetailPrice().multiply(new BigDecimal(orderRow.getQuantity())));
            order.addOrderRow(orderRow);
        });

        order.setBilling(false);
        order.setPaid(new BigDecimal(0));
        order.setTax(new BigDecimal(23));
        for (OrderRow orderRow : order.getOrderRows()) {
            bigDecimal = bigDecimal.add(orderRow.getPrice());
        }
        if (order.getDelivery().toString().equals("DHL_CASH_ON_DELIVERY"))
            bigDecimal = bigDecimal.add(new BigDecimal("14.99"));
        else if (order.getDelivery().toString().equals("DHL_PAYMENT_IN_ADVANCE"))
            bigDecimal = bigDecimal.add(new BigDecimal("9.99"));


        order.setTotal(bigDecimal);

        orderRepository.save(order);
        return new ResponseEntity<>("Zamówienie przyjęte", HttpStatus.OK);
    }

}


