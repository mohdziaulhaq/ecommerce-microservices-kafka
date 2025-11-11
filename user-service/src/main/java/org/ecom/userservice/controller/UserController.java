package org.ecom.userservice.controller;

import org.ecom.commonutils.user.dtos.UserDTO;
import org.ecom.commonutils.user.dtos.UserInfoResponse;
import org.ecom.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Public endpoint for internal service calls
    @GetMapping("/{id}")
    public ResponseEntity<UserInfoResponse> userExists(@PathVariable Long id,
                                                       @RequestHeader(value = "X-Internal-Key", required = false) String key) {

        if (!"secret123".equals(key)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDTO user = userService.getUserById(id);
        UserInfoResponse userInfoResponse = new UserInfoResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
        return ResponseEntity.ok(userInfoResponse);
    }
}

