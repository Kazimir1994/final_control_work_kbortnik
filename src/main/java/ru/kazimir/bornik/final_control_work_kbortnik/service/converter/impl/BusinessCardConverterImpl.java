package ru.kazimir.bornik.final_control_work_kbortnik.service.converter.impl;

import org.springframework.stereotype.Component;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.BusinessCard;
import ru.kazimir.bornik.final_control_work_kbortnik.service.converter.Converter;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

@Component
public class BusinessCardConverterImpl implements Converter<BusinessCardDTO, BusinessCard> {
    @Override
    public BusinessCardDTO toDTO(BusinessCard businessCar) {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setFullName(businessCar.getFullName());
        businessCardDTO.setTitle(businessCar.getTitle());
        businessCardDTO.setWorkingTelephone(businessCar.getWorkingTelephone());
        return businessCardDTO;
    }

    @Override
    public BusinessCard fromDTO(BusinessCardDTO businessCardDTO) {
        BusinessCard businessCar = new BusinessCard();
        businessCar.setFullName(businessCardDTO.getFullName());
        businessCar.setTitle(businessCardDTO.getTitle());
        businessCar.setWorkingTelephone(businessCardDTO.getWorkingTelephone());
        return businessCar;
    }
}
