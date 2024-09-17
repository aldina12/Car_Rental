package com.team_spak.car_rental.security;


import com.team_spak.car_rental.model.dto.ClientDto;
import com.team_spak.car_rental.model.dto.CreateStaffDTO;
import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.LoginDto;
import com.team_spak.car_rental.model.entity.Client;
import com.team_spak.car_rental.model.entity.Role;
import com.team_spak.car_rental.model.entity.Staff;
import com.team_spak.car_rental.model.entity.User;
import com.team_spak.car_rental.repository.ClientRepository;
import com.team_spak.car_rental.repository.RoleRepository;
import com.team_spak.car_rental.repository.StaffRepository;
import com.team_spak.car_rental.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Service
public class AccountService {

    private final ClientRepository clientRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    private StaffRepository staffRepository;

    private AuthenticationManager authenticationManager;


    @Transactional
    public String registerUser(ClientDto clientDto) {

        if (Boolean.TRUE.equals(userRepository.existsByUsername(clientDto.getUsername()))){
            throw new RuntimeException("Username already exists");
        }
        if (Boolean.TRUE.equals(userRepository.existsByEmail(clientDto.getEmail()))){
            throw new RuntimeException("Email already exists");
        }


        User user = new User();
        user.setUsername(clientDto.getUsername());
        user.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        user.setEmail(clientDto.getEmail());

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("ROLE_CLIENT").orElseThrow(()->new RuntimeException("ROLE_CLIENT")));

        user.setRoles(roles);

        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        client.setAddress(clientDto.getAddress());

        clientRepository.save(client);
        user.setClient(client);
        userRepository.save(user);

        return "User registered successfully";

    }


    @Transactional
    public String registerStaff(CreateStaffDTO createStaffDTO) {

        if (Boolean.TRUE.equals(userRepository.existsByUsername(createStaffDTO.getUsername()))){
            throw new RuntimeException("Username already exists");
        }
        if (Boolean.TRUE.equals(userRepository.existsByEmail(createStaffDTO.getEmail()))){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(createStaffDTO.getUsername());
        user.setPassword(passwordEncoder.encode(createStaffDTO.getPassword()));
        user.setEmail(createStaffDTO.getEmail());
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("ROLE_STAFF").orElseThrow(()->new RuntimeException("ROLE_STAFF")));

        user.setRoles(roles);

        Staff staff = new Staff();
        staff.setName(createStaffDTO.getName());
        staff.setAge(createStaffDTO.getAge());
        staff.setLastname(createStaffDTO.getLastname());
        staff.setExperience(createStaffDTO.getExperience());

        staffRepository.save(staff);

        user.setStaff(staff);

        userRepository.save(user);


       return "Staff registered successfully";

    }

    @Transactional
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Logged in successfully";
    }


}
