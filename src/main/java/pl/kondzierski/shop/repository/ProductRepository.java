package pl.kondzierski.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kondzierski.shop.model.product.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select distinct p from Product p " +
            "where p.id=:id")
    Product findMyProduct(@Param("id") Long id);

    @Query("select distinct p from Product p " +
            "join fetch p.productClass pc " +
            "where pc.name=:name")
    List<Product> findProductsByClassName(@Param("name") String name);

}
