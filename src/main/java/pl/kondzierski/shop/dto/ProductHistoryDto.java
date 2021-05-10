package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.ProductHistory;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class ProductHistoryDto {
    private String name;
    private BigDecimal retailPrice;
    private BigDecimal wholesalePrice;
    private Timestamp inserted;

    public ProductHistoryDto(ProductHistory productHistory){}
}
