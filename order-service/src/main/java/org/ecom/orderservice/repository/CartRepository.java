package org.ecom.orderservice.repository;

//import com.zia.electronix.express.entities.Cart;
//import com.zia.electronix.express.entities.User;
import org.ecom.orderservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, String> {

//    Optional<Cart> findByUser(User user);

}
