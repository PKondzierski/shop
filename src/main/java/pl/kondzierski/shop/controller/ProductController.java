package pl.kondzierski.shop.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kondzierski.shop.dto.ProductDto;
import pl.kondzierski.shop.mapper.ProductMapper;
import pl.kondzierski.shop.model.product.Description;
import pl.kondzierski.shop.model.product.Product;
import pl.kondzierski.shop.model.product.ProductClass;
import pl.kondzierski.shop.repository.ProductRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.SortedSet;

@RestController
public class ProductController {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('insert_user') or hasAuthority('read_user')")
    // @PreAuthorize("hasRole('client')")
    public ProductDto getProduct(@PathVariable(name = "id") Long id){
        //  return productRepository.findMyProduct(id).getProductClasses().getName();
        Product product = productRepository.findMyProduct(id);
        ProductDto productDto = productMapper.ObjectToDto(product);
        byte[] fileContent = new byte[0];
        try {
            Resource resource = new ClassPathResource(product.getImagePath());
            fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(resource.getFile())));
            String encodedImage = Base64.getEncoder().encodeToString(fileContent);
            productDto.setImage(encodedImage);
        } catch (IOException e) {
            productDto.setImage("");
        }
        return productDto;

    }

    @GetMapping("/product/{name}")
    public List<ProductDto> getProduct(@PathVariable(name = "name") String name){
        //  return productRepository.findMyProduct(id).getProductClasses().getName();
        List<Product> productsByClassName = productRepository.findProductsByClassName(name);
        List<ProductDto> productDtoList = new ArrayList<>();


        productsByClassName.forEach((product -> {
            ProductDto productDto = productMapper.ObjectToDto(product);
            byte[] fileContent = new byte[0];
            try {
                Resource resource = new ClassPathResource(product.getImagePath());
                fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(resource.getFile())));
                String encodedImage = Base64.getEncoder().encodeToString(fileContent);
                productDto.setImage(encodedImage);
            } catch (IOException e) {
                productDto.setImage("");
            }

            productDtoList.add(productDto);

        }));
        return productDtoList;

    }

}
