    package com.pratik.smart_erp.service;

    import com.pratik.smart_erp.entity.User;
    import com.pratik.smart_erp.repository.UserRepository;
    import com.pratik.smart_erp.userDTO.UserRequestDTO;
    import com.pratik.smart_erp.userDTO.UserResponseDTO;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public UserServiceImpl(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public UserResponseDTO registerUser(UserRequestDTO dto) {

            if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
                throw new RuntimeException("Username already exists");
            }

            User user = new User();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setRole(dto.getRole());

            User savedUser = userRepository.save(user);

            return new UserResponseDTO(
                    savedUser.getId(),
                    savedUser.getUsername(),
                    savedUser.getEmail(),
                    savedUser.getRole()
            );
        }

        @Override
        public List<UserResponseDTO> getAllUsers() {
            return userRepository.findAll()
                    .stream()
                    .map(user -> new UserResponseDTO(
                            user.getId(),
                            user.getUsername(),
                            user.getEmail(),
                            user.getRole()
                    ))
                    .toList();
        }

        @Override
        public Page<UserResponseDTO> getUsersWithPagination(Pageable pageable) {

            return userRepository.findAll(pageable)
                    .map(user -> new UserResponseDTO(
                            user.getId(),
                            user.getUsername(),
                            user.getEmail(),
                            user.getRole()
                    ));
        }
        @Override
        public UserResponseDTO createUser(UserRequestDTO dto) {

            User user = new User();

            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setRole(dto.getRole());

            User savedUser = userRepository.save(user);

            return new UserResponseDTO(
                    savedUser.getId(),
                    savedUser.getUsername(),
                    savedUser.getEmail(),
                    savedUser.getRole()
            );
        }

        @Override
        public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());

            if(dto.getPassword() != null && !dto.getPassword().isBlank()) {
                user.setPassword(passwordEncoder.encode(dto.getPassword()));
            }

            user.setRole(dto.getRole());

            User updatedUser = userRepository.save(user);

            return new UserResponseDTO(
                    updatedUser.getId(),
                    updatedUser.getUsername(),
                    updatedUser.getEmail(),
                    updatedUser.getRole()
            );
        }

        @Override
        public void deleteUser(Long id) {

            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            userRepository.delete(user);
        }
    }