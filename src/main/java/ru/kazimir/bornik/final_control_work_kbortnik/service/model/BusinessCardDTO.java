package ru.kazimir.bornik.final_control_work_kbortnik.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BusinessCardDTO {

    private Long id;

    @NotNull
    @Size(min = 5)
    private String title;

    private String fullName;

    @NotNull
    @Size(max= 20)
    private String workingTelephone;

    private UserDTO userDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWorkingTelephone() {
        return workingTelephone;
    }

    public void setWorkingTelephone(String workingTelephone) {
        this.workingTelephone = workingTelephone;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
