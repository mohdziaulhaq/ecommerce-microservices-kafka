package org.ecom.userservice.repository;

//import com.notevault.enums.AppRole;
//import com.notevault.models.Role;
import org.ecom.commonutils.enums.user.AppRole;
import org.ecom.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
