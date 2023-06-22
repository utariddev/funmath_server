package org.utarid.funmath.dto;

import jakarta.validation.constraints.Size;

public class UserDTO {
    @Size(min = 8, max = 64, message = "username size is wrong")
    private String username;
    @Size(min = 8, max = 64, message = "password size is wrong")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
