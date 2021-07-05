package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.ProductSpecification;
import pl.kondzierski.shop.model.product.Specification;
import java.time.LocalDate;

@Getter
@Setter
public class ProductSpecificationDto {

 //   private SpecificationDto specification;
    private int valueInt;
    private String valueVarchar;
    private LocalDate valueDate;
    private SpecificationDto specification;
    public ProductSpecificationDto(ProductSpecification productSpecification){}

}
