package ru.kazimir.bornik.final_control_work_kbortnik.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kazimir.bornik.final_control_work_kbortnik.service.BusinessCardService;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

import javax.validation.Valid;

import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_ADMIN_BUSINESS_CARD_ADD_URL;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_ADMIN_BUSINESS_CARD_DELETE_URL;
import static ru.kazimir.bornik.final_control_work_kbortnik.constant.ApiURLConstants.API_V1_ADMIN;

@RestController
@RequestMapping(API_V1_ADMIN)
public class AdminAPIController {
    private final static Logger logger = LoggerFactory.getLogger(AdminAPIController.class);
    private final BusinessCardService businessCardService;

    @Autowired
    public AdminAPIController(BusinessCardService businessCardService) {
        this.businessCardService = businessCardService;
    }

    @PostMapping(API_ADMIN_BUSINESS_CARD_ADD_URL)
    public ResponseEntity addBusinessCard(@RequestBody @Valid BusinessCardDTO businessCardDTO, BindingResult bindingResult) {
        logger.info("Request API to add a Business Card {}", businessCardDTO);
        if (bindingResult.hasErrors()) {
            logger.info("Request denied. Error code := {}.", bindingResult.getAllErrors());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        businessCardService.add(businessCardDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(API_ADMIN_BUSINESS_CARD_DELETE_URL)
    public ResponseEntity deleteBusinessCard(@PathVariable("id")  Long id) {
        logger.info("Requests delete BusinessCard by id := {}.", id);
        businessCardService.deleteById(id);
        logger.info("BusinessCard removed successfully.");
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
