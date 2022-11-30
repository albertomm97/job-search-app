package jobity.apps.jobboard.controller.health_check;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckGetController {
    @GetMapping("/health-check")
    public ResponseEntity<String> run() {
        return ResponseEntity.status(HttpStatus.OK).body("Up and Running");
    }
}
