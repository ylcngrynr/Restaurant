package com.restaurant.services;

import com.restaurant.dao.UserRepository;
import com.restaurant.domain.Users;
import com.restaurant.domain.dtos.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public LoginResponseDTO validateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .map(users -> {
                    if (users.getPassword().equals(password)) {
                        return new LoginResponseDTO("Giriş Başarılı", true);
                    } else {
                        return new LoginResponseDTO("Şifre Hatalı", false);
                    }
                })
                .orElse(new LoginResponseDTO("Kullanıcı bulunamadı", false));
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Users addUser(Users users) {
       return userRepository.save(users);
    }

    public List<Users> getAllUsers() {
    return userRepository.findAll();
    }
}

