package ru.kazimir.bornik.final_control_work_kbortnik.service;

import ru.kazimir.bornik.final_control_work_kbortnik.service.model.UserDTO;

public interface UserService {
    UserDTO getByEmail(String email);
}
