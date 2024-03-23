package com.techshopmsuser.dto;

import com.techshopmsuser.entity.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UserDTO {

    @NotNull
    private String name;
    @NotNull
    private String CPF;
    @NotNull
    private String origin;
    @NotNull
    private LocalDateTime birthDate;
    @NotNull
    private String address;
    @NotNull
    private String mobile;
    @NotNull
    private String email;

    public UserDTO(User user) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
