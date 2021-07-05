package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.ProductSpecification;
import pl.kondzierski.shop.model.product.Specification;

@Getter
@Setter
public class SpecificationDto {
    private Long id;
    private String name;
    public SpecificationDto(Specification specification){}
}
