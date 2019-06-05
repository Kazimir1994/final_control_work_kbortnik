package ru.kazimir.bornik.final_control_work_kbortnik.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.BusinessCardRepository;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.UserRepository;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.BusinessCard;
import ru.kazimir.bornik.final_control_work_kbortnik.repository.model.User;
import ru.kazimir.bornik.final_control_work_kbortnik.service.BusinessCardService;
import ru.kazimir.bornik.final_control_work_kbortnik.service.converter.Converter;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessCardServiceImpl implements BusinessCardService {
    private final UserRepository userRepository;
    private final Converter<BusinessCardDTO, BusinessCard> businessCardConverter;
    private final BusinessCardRepository businessCardRepository;

    public BusinessCardServiceImpl(UserRepository userRepository,
                                   Converter<BusinessCardDTO, BusinessCard> businessCardConverter,
                                   BusinessCardRepository businessCardRepository) {
        this.userRepository = userRepository;
        this.businessCardConverter = businessCardConverter;
        this.businessCardRepository = businessCardRepository;
    }

    @Override
    @Transactional
    public void add(BusinessCardDTO businessCardDTO) {
        BusinessCard businessCard = businessCardConverter.fromDTO(businessCardDTO);
        User user = userRepository.findById(businessCardDTO.getUserDTO().getId());
        businessCard.setUser(user);
        businessCardRepository.persist(businessCard);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        BusinessCard businessCard = businessCardRepository.findById(id);
        businessCardRepository.remove(businessCard);
    }

    @Override
    @Transactional
    public List<BusinessCardDTO> getBusinessCardsByIdUser(Long id) {
        List<BusinessCard> businessCardList = businessCardRepository.getBusinessCardsByIdUser(id);
        return businessCardList.stream().map(businessCardConverter::toDTO).collect(Collectors.toList());
    }
}
