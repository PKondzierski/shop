package pl.kondzierski.shop.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@Setter
@Table(name = "product_history")
@Embeddable
public class ProductHistory {

    private String name;
    @Column(name = "retail_price")
    private BigDecimal retailPrice;
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    private Timestamp inserted;

}
