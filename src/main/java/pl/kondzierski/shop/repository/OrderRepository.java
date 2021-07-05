package pl.kondzierski.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kondzierski.shop.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
