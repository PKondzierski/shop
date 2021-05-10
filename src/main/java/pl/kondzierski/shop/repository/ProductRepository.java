package pl.kondzierski.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kondzierski.shop.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select distinct p from Product p " +
            "where p.id=:id")
    Product findMyProduct(@Param("id") Long id);

}
