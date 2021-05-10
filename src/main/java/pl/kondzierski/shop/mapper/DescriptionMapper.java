package pl.kondzierski.shop.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.kondzierski.shop.dto.DescriptionDto;
import pl.kondzierski.shop.model.product.Description;

@Mapper(componentModel = "spring")
public interface DescriptionMapper extends GlobalMapper<Description, DescriptionDto> {
    @Override
    DescriptionDto ObjectTtoDto(Description description);

    @Override
    Description DtoToObject(DescriptionDto descriptionDto);
}
