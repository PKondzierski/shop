package pl.kondzierski.shop.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "product_specification")
public class ProductSpecification implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specification_id")
    private Specification specification;


    @Column(name="value_int")
    private int valueInt;
    @Column(name="value_varchar")
    private char valueVarchar;
    @Column(name="value_date")
    private LocalDate valueDate;

}
