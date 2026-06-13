package com.pratik.smart_erp.service;

import com.pratik.smart_erp.userDTO.UserRequestDTO;
import com.pratik.smart_erp.userDTO.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    Page<UserResponseDTO> getUsersWithPagination(Pageable pageable);

    UserResponseDTO createUser(UserRequestDTO dto);

    UserResponseDTO updateUser(Long id, UserRequestDTO dto);

    void deleteUser(Long id);
}