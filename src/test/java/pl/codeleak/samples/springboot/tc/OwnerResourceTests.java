package pl.codeleak.samples.springboot.tc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OwnerResourceTests {

    @Autowired
    WebApplicationContext wac;

    @Test
    void findAllReturnsJohnDoe() throws Exception {
        // @formatter:off
        given()
                .webAppContextSetup(wac)
        .when()
                .get("/owners")
        .then()
                .status(HttpStatus.OK)
                .body(
                        "_embedded.owners.firstName", containsInAnyOrder("John"),
                        "_embedded.owners.lastName", containsInAnyOrder("Doe")
                );
        // @formatter:on
    }
}

