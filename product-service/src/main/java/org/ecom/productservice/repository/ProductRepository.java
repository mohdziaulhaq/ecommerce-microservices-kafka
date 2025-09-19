package org.ecom.productservice.repository;

//import com.zia.electronix.express.entities.Category;
import org.ecom.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    //search
    Page<Product> findByProductNameContaining(String productName, Pageable pageable);

    Page<Product> findByLiveTrue(Pageable pageable);

//    Page<Product> findByCategory(Category category, Pageable pageable);
}
