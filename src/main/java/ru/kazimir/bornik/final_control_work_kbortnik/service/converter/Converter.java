package ru.kazimir.bornik.final_control_work_kbortnik.service.converter;

public interface Converter<ObjectDTO, Object> {
    ObjectDTO toDTO(Object object);

    Object fromDTO(ObjectDTO ObjectDTO);
}