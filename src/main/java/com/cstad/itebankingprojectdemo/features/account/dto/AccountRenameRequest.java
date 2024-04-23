package com.cstad.itebankingprojectdemo.features.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AccountRenameRequest (
        @NotBlank(message = "Trov tae dak name tmey")
        @Size(message = "less then 100 <")
        String newName
){
}