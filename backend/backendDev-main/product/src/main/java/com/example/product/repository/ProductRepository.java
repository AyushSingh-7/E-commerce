package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface ProductRepository extends CrudRepository<Product,Integer > {

    @Query (value = "SELECT * FROM product WHERE name LIKE %:name% order by sold_quantity desc, rating desc, quantity desc, price;", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

    @Query (value = "SELECT * FROM product WHERE category_name = ?1 order by sold_quantity desc, rating desc, price, quantity desc;", nativeQuery = true)
    List<Product> findByCategoryName(String name);

    @Transactional
    @Modifying
    @Query (value = "UPDATE product p SET p.quantity = p.quantity - :quantity, p.sold_quantity = p.sold_quantity +  :quantity WHERE p.id = :id", nativeQuery = true)
    void updateQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);

    @Query(value = "SELECT * FROM product order by price, strike_price desc, rating desc LIMIT 6", nativeQuery = true)
    List<Product> recommendation();

    List<Product> findByMerchantId(String id);
}
