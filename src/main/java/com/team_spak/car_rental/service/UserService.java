package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;
import com.team_spak.car_rental.mappers.UserMapper;
import com.team_spak.car_rental.model.entity.User;
import com.team_spak.car_rental.repository.UserRepository;
import com.team_spak.car_rental.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements UserServiceInterface {
    private UserRepository userRepository;
    private UserMapper userMapper;


    @Override
    public List<ResponseUserDto> findAllUsers() {
        List<User> userList = userRepository.findAll();
        List<ResponseUserDto> responseUserDtoList = new ArrayList<>();
        for (User user : userList) {
            responseUserDtoList.add(userMapper.mapToResponse(user));
        }
        return responseUserDtoList;
    }

    @Override
    public ResponseUserDto saveNewUser(CreateUserDto createUserDto) {
        User newUser = userMapper.mapToEntity(createUserDto);
        User savedUser = userRepository.save(newUser);
        return userMapper.mapToResponse(savedUser);
    }

    @Override
    public ResponseUserDto findUserById(long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
        return userMapper.mapToResponse(existingUser);
    }

    @Override
    public ResponseUserDto updateExistingUser(long id, CreateUserDto createUserDto) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        existingUser.setUsername(createUserDto.getUsername());
        existingUser.setPassword(createUserDto.getPassword());
        User savedUser = userRepository.save(existingUser);
        return userMapper.mapToResponse(savedUser);
    }

    @Override
    public String deleteUser(long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        userRepository.delete(existingUser);

        return "User with id" + id + "was succefully deleted";
    }
}