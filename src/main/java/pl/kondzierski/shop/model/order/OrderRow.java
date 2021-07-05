package pl.kondzierski.shop.model.order;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.order.Order;
import pl.kondzierski.shop.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_row")
@Getter
@Setter
public class OrderRow implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal price;
    private short quantity;


}
