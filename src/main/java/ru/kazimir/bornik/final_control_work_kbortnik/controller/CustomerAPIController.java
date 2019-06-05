package ru.kazimir.bornik.final_control_work_kbortnik.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kazimir.bornik.final_control_work_kbortnik.service.BusinessCardService;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

import java.util.List;

import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_V1_CUSTOMER;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_V1_CUSTOMER_SHOWING_URL;

@RestController
@RequestMapping(API_V1_CUSTOMER)
public class CustomerAPIController {
    private final static Logger logger = LoggerFactory.getLogger(CustomerAPIController.class);
    private final BusinessCardService businessCardService;

    public CustomerAPIController(BusinessCardService businessCardService) {
        this.businessCardService = businessCardService;
    }

    @GetMapping(API_V1_CUSTOMER_SHOWING_URL)
    public ResponseEntity<List<BusinessCardDTO>> getBusinessCards(@PathVariable("id") Long id) {
        logger.info("Request for receiving BusinessCards user id:= {}", id);
        List<BusinessCardDTO> businessCardDTOList = businessCardService.getBusinessCardsByIdUser(id);
        logger.info("Send a list of businessCards. := {}.", businessCardDTOList);
        return new ResponseEntity<>(businessCardDTOList, HttpStatus.OK);
    }
}
