package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.Description;
import pl.kondzierski.shop.model.product.Product;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal retailPrice;
    private BigDecimal wholesalePrice;
    private int quantity;
    private BigDecimal discount;
    private String imagePath;
    private Timestamp created;
    private Timestamp updated;
    private Set<ProductHistoryDto> productHistory = new HashSet<>();
    private SortedSet<DescriptionDto> description = new TreeSet<>(Comparator.comparingInt(DescriptionDto::getSequenceNumber));
    private Set<CategoryDto> categories = new HashSet<>();
    public ProductDto(Product product){}
}
