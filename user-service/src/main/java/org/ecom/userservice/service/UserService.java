package org.ecom.userservice.service;

//import com.notevault.dtos.UserDTO;
//import com.notevault.models.User;

import org.ecom.commonutils.user.dtos.UserDTO;
import org.ecom.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void updateUserRole(Long userId, String roleName);
    List<User> getAllUsers();
    UserDTO getUserById(Long id);

    User findByUsername(String username);
    void updatePassword(Long userId, String newPassword);

//    void generarePasswordResetToken(String email);

    void resetPassword(String token, String newPassword);

    Optional<User> findByEmail(String email);


    User registerUser(User user);
}
