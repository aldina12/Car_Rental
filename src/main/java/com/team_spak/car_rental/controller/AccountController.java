package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.*;
import com.team_spak.car_rental.security.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Operation(
            summary = "Login REST API",
            description = "Login REST API is used to authenticate user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @PostMapping("/register")
    public ResponseEntity<String> registerUser (@Valid @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(accountService.registerUser(clientDto));
    }

    @Operation(
            summary = "Login REST API",
            description = "Login REST API is used to authenticate user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    @PostMapping("/registerStaff")
    public ResponseEntity<String> registerStaff (@Valid @RequestBody CreateStaffDTO createStaffDTO) {
        return ResponseEntity.ok(accountService.registerStaff(createStaffDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String>  login (@Valid @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(accountService.login(loginDto));

    }


}
