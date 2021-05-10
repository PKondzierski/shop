package pl.kondzierski.shop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kondzierski.shop.model.product.Category;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;

    public CategoryDto(Category category){}

}
