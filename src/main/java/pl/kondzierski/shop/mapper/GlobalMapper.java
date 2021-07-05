package pl.kondzierski.shop.mapper;

import org.mapstruct.InheritInverseConfiguration;


public interface GlobalMapper <T,S> {
    S ObjectToDto (T t);
    @InheritInverseConfiguration
    T DtoToObject (S s);
}
