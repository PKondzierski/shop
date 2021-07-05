package pl.kondzierski.shop.model.order;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal total;
    private BigDecimal paid;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean billing;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Delivery delivery;
    private BigDecimal tax;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private Set<OrderRow> orderRows = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name="shipping_address",
            joinColumns = @JoinColumn(name="order_id")
    )
    private Set<ShippingAddress> shippingAddress;

    public void addOrderRow(OrderRow orderRow){
        this.orderRows.add(orderRow);
        orderRow.setOrder(this);
    }
}
