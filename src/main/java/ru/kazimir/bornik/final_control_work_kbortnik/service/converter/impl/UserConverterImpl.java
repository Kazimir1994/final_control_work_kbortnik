package ru.kazimir.bornik.final_control_work_kbortnik.service.converter.impl;

import org.springframework.stereotype.Component;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.User;
import ru.kazimir.bornik.final_control_work_kbortnik.service.converter.Converter;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.UserDTO;

@Component
public class UserConverterImpl implements Converter<UserDTO, User> {

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    @Override
    public User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        return user;
    }
}
