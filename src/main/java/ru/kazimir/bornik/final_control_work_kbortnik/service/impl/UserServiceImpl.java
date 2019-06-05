package ru.kazimir.bornik.final_control_work_kbortnik.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.UserRepository;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.User;
import ru.kazimir.bornik.final_control_work_kbortnik.service.UserService;
import ru.kazimir.bornik.final_control_work_kbortnik.service.converter.Converter;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Converter<UserDTO, User> userConverter;

    public UserServiceImpl(UserRepository userRepository,
                           Converter<UserDTO, User> userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Transactional
    @Override
    public UserDTO getByEmail(String email) {
        User user = userRepository.getByEmail(email);
        if (user == null) {
            return null;
        }
        return userConverter.toDTO(user);
    }
}
