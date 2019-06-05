package ru.kazimir.bornik.final_control_work_kbortnik.service;

import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

import java.util.List;

public interface BusinessCardService {
    void add(BusinessCardDTO businessCardDTO);

    void deleteById(Long id);

    List<BusinessCardDTO> getBusinessCardsByIdUser(Long id);
}
