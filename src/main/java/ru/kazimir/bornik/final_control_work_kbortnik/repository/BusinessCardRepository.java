package ru.kazimir.bornik.final_control_work_kbortnik.repository;

import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.BusinessCard;

import java.util.List;

public interface BusinessCardRepository extends GenericRepository<Long, BusinessCard> {
    List<BusinessCard> getBusinessCardsByIdUser(Long id);
}
