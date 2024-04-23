package com.cstad.itebankingprojectdemo.features.auth;

public interface AuthService {
    Boolean authenticate(String email, String password);

}
