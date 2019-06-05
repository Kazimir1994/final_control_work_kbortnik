package ru.kazimir.bornik.final_control_work_kbortnik.repository;


import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {
    User getByEmail(String email);
}
