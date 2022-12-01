package jobity.apps.jobboard.controller.health_check;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HealthCheckGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void health_check_should_return_httpOK() throws Exception {
        ResultMatcher response = content()
                .string("Up and Running");

        mockMvc
            .perform(get("/health-check"))
            .andExpect(status().is(200))
            .andExpect(response);
    }
}
