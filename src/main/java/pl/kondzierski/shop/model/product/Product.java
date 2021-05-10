package pl.kondzierski.shop.model.product;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "retail_price")
    private BigDecimal retailPrice;
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    private int quantity;
    private BigDecimal discount;
    @Column(name = "image_path")
    private String imagePath;
    private Timestamp created;
    private Timestamp updated;

    @ElementCollection
    @CollectionTable(
            name="description",
            joinColumns = @JoinColumn(name="product_id")
    )
    @SortComparator(SortBySequenceNumber.class)
    private SortedSet<Description> description = new TreeSet<>();
    public static class SortBySequenceNumber implements Comparator<Description> {
        @Override
        public int compare(Description o1, Description o2) {
            Short seq1 = o1.getSequenceNumber();
            Short seq2 = o2.getSequenceNumber();
            return seq1.compareTo(seq2);
        }
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_class_id", referencedColumnName = "id")
    private ProductClass productClasses;

    @OneToMany(mappedBy = "product")
    Set<ProductSpecification> productSpecifications = new HashSet<>();

    @ManyToMany()
            @JoinTable(
                    name = "product_category",
                    joinColumns = @JoinColumn(name="product_id"),
                    inverseJoinColumns = @JoinColumn(name = "category_id")
            )

    private Set<Category> categories = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name="product_history",
            joinColumns = @JoinColumn(name="product_id")
    )
    private Set<ProductHistory> productHistory = new HashSet<>();




}
