package ru.kazimir.bornik.final_control_work_kbortnik.service.model;


import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.UserRoleEnum;

public class UserDTO {
    private Long id;
    private String surname;
    private String email;
    private String password;
    private UserRoleEnum role;

    public UserDTO(Long id) {
        this.id = id;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}