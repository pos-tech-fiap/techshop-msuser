package com.techshopmsuser.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String CPF;
    @NotNull
    private LocalDateTime birthDate;
    @NotNull
    private String address;
    @NotNull
    private String mobile;
    @NotNull
    private String email;

    public User() {    }

    public User(@NotNull String name, @NotNull String CPF, @NotNull LocalDateTime birthDate, @NotNull String address, @NotNull String mobile, @NotNull String email) {
        this.name = name;
        this.CPF = CPF;
        this.birthDate = birthDate;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
