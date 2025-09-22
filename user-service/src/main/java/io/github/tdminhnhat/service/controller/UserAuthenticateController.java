package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.service.model.dto.UserRegisterDto;
import io.github.tdminhnhat.service.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-auth")
@RequiredArgsConstructor
public class UserAuthenticateController {

    private final IUserService userService;

    public ResponseEntity<?> login(
            @RequestParam("token") String token
    ) {
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto request) {
        return ResponseEntity.ok(userService.add(request));
    }
}
