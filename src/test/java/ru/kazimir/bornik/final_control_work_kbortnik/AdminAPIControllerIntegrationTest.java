package ru.kazimir.bornik.final_control_work_kbortnik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class AdminAPIControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    final private String password = "admin";
    final private String login = "kazimir@mail.ru";

    @Before
    public void init() {
        restTemplate.withBasicAuth(login, password);
    }

    @Test
    public void testShouldAddBusinessCardAPI() {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setFullName("TEST");
        businessCardDTO.setTitle("TEST_TEST");
        businessCardDTO.setWorkingTelephone("+375447597989");
        businessCardDTO.setUserDTO(new UserDTO(1L));
        final String Url = "http://localhost:" + randomServerPort + "/api/v1/admin/business_card";
        ResponseEntity responseEntity =
                restTemplate.withBasicAuth(login, password).postForEntity(Url, businessCardDTO, ResponseEntity.class);
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void shouldBusinessCard() {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setFullName("TEST");
        businessCardDTO.setTitle("TEST_TEST");
        businessCardDTO.setWorkingTelephone("+375447597989");
        businessCardDTO.setUserDTO(new UserDTO(1L));
        final String Url = "http://localhost:" + randomServerPort + "/api/v1/admin/business_card";
        ResponseEntity responseEntity1 =
                restTemplate.withBasicAuth(login, password).postForEntity(Url, businessCardDTO, ResponseEntity.class);

        final String uri = "http://localhost:" + randomServerPort + "/api/v1/admin/business_card/1";
        ResponseEntity responseEntity2 = restTemplate
                .withBasicAuth(login, password).exchange(uri, HttpMethod.DELETE,null,ResponseEntity.class);
        Assert.assertEquals(HttpStatus.ACCEPTED, responseEntity2.getStatusCode());
    }

    @Test
    public void testShouldNotAppearBusinessCard() {
        BusinessCardDTO businessCardDTO = new BusinessCardDTO();
        businessCardDTO.setWorkingTelephone("+375447597989");
        businessCardDTO.setUserDTO(new UserDTO(1L));
        final String Url = "http://localhost:" + randomServerPort + "/api/v1/admin/business_card";
        ResponseEntity responseEntity =
                restTemplate.withBasicAuth(login, password).postForEntity(Url, businessCardDTO, ResponseEntity.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
