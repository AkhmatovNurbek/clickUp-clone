package uz.clickup.clickupclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uz.clickup.clickupclone.entity.AuthUser;
import uz.clickup.clickupclone.payload.ApiResponse;
import uz.clickup.clickupclone.payload.LoginDto;
import uz.clickup.clickupclone.payload.RegisterDto;
import uz.clickup.clickupclone.security.JwtProvider;
import uz.clickup.clickupclone.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(value = "/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto) {
        ApiResponse apiResponse = authService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        try {


            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(),
                    loginDto.getPassword()
            ));
            AuthUser user = (AuthUser) authenticate.getPrincipal();
            String token = jwtProvider.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.ok(new ApiResponse("Parol yoki login xato" ,false)  );
        }

    }
}
