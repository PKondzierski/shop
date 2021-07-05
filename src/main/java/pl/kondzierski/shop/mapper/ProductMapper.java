package pl.kondzierski.shop.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kondzierski.shop.dto.DescriptionDto;
import pl.kondzierski.shop.dto.ProductClassDto;
import pl.kondzierski.shop.dto.ProductDto;
import pl.kondzierski.shop.model.product.Description;
import pl.kondzierski.shop.model.product.Product;
import pl.kondzierski.shop.model.product.ProductClass;

import java.util.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = DescriptionMapper.class)
public abstract class ProductMapper implements GlobalMapper <Product, ProductDto> {

    private DescriptionMapper descriptionMapper;


    @Override
    public abstract ProductDto ObjectToDto(Product product);

    SortedSet<DescriptionDto> map2 (SortedSet<Description> treeSet){
        SortedSet<DescriptionDto> descriptionDto = new TreeSet<>(Comparator.comparingInt(DescriptionDto::getSequenceNumber));

        for (Description description : treeSet) {
            descriptionDto.add(descriptionMapper.ObjectToDto(description));
        }
        return descriptionDto;
    }

    @Override
    public abstract Product DtoToObject(ProductDto productDto);

    @Autowired
    public void setDescriptionMapper(DescriptionMapper descriptionMapper) {
        this.descriptionMapper = descriptionMapper;
    }

}
