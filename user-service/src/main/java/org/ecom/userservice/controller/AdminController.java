package org.ecom.userservice.controller;

//import com.notevault.dtos.UserDTO;
//import com.notevault.models.User;
//import com.notevault.services.UserService;
import org.ecom.commonutils.user.dtos.UserDTO;
import org.ecom.userservice.model.User;
import org.ecom.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RefreshScope
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Value("${frontend.url}")
    private String frontendUrl;

    @GetMapping("frontend-url")
    public ResponseEntity<String> getFrontendUrl() {
        return new ResponseEntity<>(frontendUrl, HttpStatus.OK);
    }



    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("update-role")
    public ResponseEntity<String> updateUserRole(@RequestParam Long userId, @RequestParam String roleName) {
        userService.updateUserRole(userId,roleName);
        return new ResponseEntity<>("Role updated successfully", HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
