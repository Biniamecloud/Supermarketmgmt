package com.supermarket_management_system.services;



import com.supermarket_management_system.dto.AuthRequest;
import com.supermarket_management_system.dto.AuthResponse;
import com.supermarket_management_system.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
