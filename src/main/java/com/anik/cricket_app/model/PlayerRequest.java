package com.anik.cricket_app.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlayerRequest {
    @NotNull
    @NotEmpty
    private String role;
    @NotEmpty
    @NotNull
    private String name;
}
