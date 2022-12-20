package jobity.apps.jobboard.controller.offers;

import jobity.jobboard.companies.domain.CompanyId;
import jobity.jobboard.offers.application.create.CreateOfferCommand;
import jobity.jobboard.offers.application.create.OfferCreator;
import jobity.jobboard.offers.domain.*;
import jobity.jobboard.shared.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OfferPutControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OfferRepository repository;

    @Test
    void should_create_a_valid_offer() throws Exception {
        String body = "{\n" +
                "    \"companyId\": \"decf33ca-81a7-419f-a07a-74f214e928e5\",\n" +
                "    \"title\": \"goooooood titttlelee\",\n" +
                "    \"salary\": 5000,\n" +
                "    \"minimumExperience\": 1,\n" +
                "    \"description\": \"kdjflksadjfklsadjkfjaskfjksajdfkajsdkfj skljakfjsakldjfkj kdjafk\",\n" +
                "    \"categories\": [\n" +
                "        {\n" +
                "            \"value\":\"Backend\",\n" +
                "            \"type\": \"category\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\":\"Remote\",\n" +
                "            \"type\": \"type\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\":\"Alicante\",\n" +
                "            \"type\": \"place\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\":\"Degree\",\n" +
                "            \"type\": \"study_level\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\":\"Full Time\",\n" +
                "            \"type\": \"work_time\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        String endpoint = "/offers/decf33ca-81a7-419f-a07a-74f214e928e5";

        mockMvc
            .perform(request(HttpMethod.PUT, endpoint).content(body).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is(201));
    }
}
