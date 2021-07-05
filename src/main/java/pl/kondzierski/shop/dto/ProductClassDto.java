package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.ProductClass;

@Getter
@Setter
public class ProductClassDto {
    private Long id;
    private String name;

    public ProductClassDto(ProductClass productClass) { }
}
