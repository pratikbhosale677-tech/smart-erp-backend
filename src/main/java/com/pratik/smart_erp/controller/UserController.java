package com.pratik.smart_erp.controller;

import com.pratik.smart_erp.response.ApiResponse;
import com.pratik.smart_erp.service.UserService;
import com.pratik.smart_erp.userDTO.UserRequestDTO;
import com.pratik.smart_erp.userDTO.UserResponseDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // =========================
    // PUBLIC - REGISTER USER
    // =========================
    @PostMapping("/register")
    public ApiResponse<UserResponseDTO> register(@RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.registerUser(dto);

        return new ApiResponse<>(
                "success",
                "User registered successfully",
                user
        );
    }

    // =========================
    // ADMIN ONLY - GET ALL USERS
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ApiResponse<List<UserResponseDTO>> getAllUsers() {

        List<UserResponseDTO> users = userService.getAllUsers();

        return new ApiResponse<>(
                "success",
                "Users fetched successfully",
                users
        );
    }

    // =========================
    // ADMIN ONLY - CREATE USER
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<UserResponseDTO> createUser(
            @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.createUser(dto);

        return new ApiResponse<>(
                "success",
                "User created successfully",
                user
        );
    }

    // =========================
    // ADMIN ONLY - UPDATE USER
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.updateUser(id, dto);

        return new ApiResponse<>(
                "success",
                "User updated successfully",
                user
        );
    }

    // =========================
    // ADMIN ONLY - DELETE USER
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return new ApiResponse<>(
                "success",
                "User deleted successfully",
                "OK"
        );
    }

    // =========================
    // PAGINATION API (ADMIN ONLY)
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paged")
    public ApiResponse<Page<UserResponseDTO>> getUsersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<UserResponseDTO> users = userService.getUsersWithPagination(pageable);

        return new ApiResponse<>(
                "success",
                "Users fetched with pagination",
                users
        );
    }

    // =========================
    // ADMIN TEST ENDPOINT
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/test")
    public ApiResponse<String> adminTest() {

        return new ApiResponse<>(
                "success",
                "Admin access granted",
                "OK"
        );
    }

    // =========================
    // USER + ADMIN TEST ENDPOINT
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/access/test")
    public ApiResponse<String> userTest() {

        return new ApiResponse<>(
                "success",
                "User or Admin access granted",
                "OK"
        );
    }
}