package com.nib.runningapp.controllers;

import com.nib.runningapp.dtos.AuthenticationRequestDTO;
import com.nib.runningapp.dtos.GoogleUserDTO;
import com.nib.runningapp.dtos.UserCreateDTO;
import com.nib.runningapp.dtos.UserDTO;
import com.nib.runningapp.repositories.UserRepository;
import com.nib.runningapp.security.jwt.JwtService;
import com.nib.runningapp.services.AuthService;
import com.nib.runningapp.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private  final UserService userService;

    @Operation(summary = "Authenticate user")
    @PostMapping("/authenticate")
    public ResponseEntity<?> authentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        GoogleUserDTO googleUserDTO = jwtService.parseJwtToken(token);
        return ResponseEntity.ok(authService.authenticate(googleUserDTO));
    }

    @Operation(summary = "Authenticate user with username and password")
    @PostMapping("/authenticate-2")
    public ResponseEntity<?> authenticationWithUsername(AuthenticationRequestDTO request) {
        UserDTO user = authService.authenticateWithUserName(request);
        if(user == null) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public ResponseEntity<?> register(UserCreateDTO request) {
        Boolean status = userService.createUser(request);
        if(Boolean.FALSE.equals(status)) {
            return ResponseEntity.badRequest().body("Some filed is invalid");
        }
        return ResponseEntity.ok("Create user successfully");
    }

//    @Operation(summary = "Authenticate user")
//    @PostMapping("/test")
//    public ResponseEntity<?> test(String token) {
//        GoogleUserDTO googleUserDTO = jwtService.parseJwtToken(token);
//        return ResponseEntity.ok(authService.authenticate(googleUserDTO));
//    }

//    @Operation(summary = "Register user")
//    @PostMapping("/register")
//    public ResponseEntity<Map<String, String>> register(String username, String password) {
//        Map<String, String> response = authService.register(username, password);
//        if (response.get("status") != null) {
//            return ResponseEntity.badRequest().body(response);
//        }
//        return ResponseEntity.ok(response);
//    }
}
