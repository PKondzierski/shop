package pl.kondzierski.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kondzierski.shop.dto.ProductDto;
import pl.kondzierski.shop.mapper.ProductMapper;
import pl.kondzierski.shop.model.product.Description;
import pl.kondzierski.shop.model.product.Product;
import pl.kondzierski.shop.repository.ProductRepository;

import java.util.SortedSet;

@RestController()
public class ProductController {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id){
\       // return productRepository.findMyProduct(id).getDescription();
        return productMapper.ObjectTtoDto(productRepository.findMyProduct(id));
    }

}
