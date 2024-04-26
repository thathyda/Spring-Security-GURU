package com.cstad.itebankingprojectdemo.features.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequest(

        @NotBlank(message = "Old Password is required")
        String oldPassword,
        @NotBlank(message = "New Password is required")
        String newPassword,
        @NotBlank(message = "Confirm Password is required")
        String confirmedPassword
){
}
