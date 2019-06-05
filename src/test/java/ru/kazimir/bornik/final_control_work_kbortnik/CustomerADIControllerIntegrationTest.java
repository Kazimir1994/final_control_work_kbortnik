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
import org.springframework.test.context.junit4.SpringRunner;
import ru.kazimir.bornik.final_control_work_kbortnik.service.model.BusinessCardDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerADIControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    final private String password = "user";
    final private String login = "user@mail.ru";


    @Before
    public void init() {
        restTemplate.withBasicAuth(login, password);
    }

    @Test
    public void shouldReturnTheSheetWithTheBusinessCards() {
        final String Url = "http://localhost:" + randomServerPort + "/api/v1/customer//business_card/1";
        BusinessCardDTO[] itemDTOS =
                restTemplate.withBasicAuth(login, password).getForObject(Url, BusinessCardDTO[].class);
        Assert.assertNotNull(itemDTOS);
    }
}
