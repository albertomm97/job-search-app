package jobity.apps.jobboard.controller.offers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OfferPutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_create_a_valid_offer() throws Exception {
        String body = "{\"title\": \"The best course\", \"salary\": \"5\"}";
        String endpoint = "/offers/decf33ca-81a7-419f-a07a-74f214e928e5";

        mockMvc
            .perform(request(HttpMethod.PUT, endpoint).content(body).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is(201))
            .andExpect(content().string(""));
    }
}
