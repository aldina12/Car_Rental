package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;

import java.util.List;

public interface UserServiceInterface {

    public List<ResponseUserDto> findAllUsers();

    public ResponseUserDto saveNewUser(CreateUserDto createUserDto);

    public ResponseUserDto findUserById(long id);

    public ResponseUserDto updateExistingUser(long id, CreateUserDto createUserDto);

    public String deleteUser(long id);


}
