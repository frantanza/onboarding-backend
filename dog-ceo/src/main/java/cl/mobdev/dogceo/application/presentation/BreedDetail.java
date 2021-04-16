package cl.mobdev.dogceo.application.presentation;

import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.application.presentation.body.InfoBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1")
@RestController
public interface BreedDetail {
    @PostMapping(value = "/info", consumes = "application/json", produces = "application/json")
    ResponseEntity<BreedInfo> info(@RequestBody InfoBody infoBody);
}