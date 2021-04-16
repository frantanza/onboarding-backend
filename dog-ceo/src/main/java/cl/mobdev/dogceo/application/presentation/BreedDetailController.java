package cl.mobdev.dogceo.application.presentation;

import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.application.domain.usecase.BreedInfoUseCase;
import cl.mobdev.dogceo.application.presentation.body.InfoBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BreedDetailController implements BreedDetail {

    private final BreedInfoUseCase breedInfoUseCase;

    public BreedDetailController(BreedInfoUseCase breedInfoUseCase) {
        this.breedInfoUseCase = breedInfoUseCase;
    }

    @Override
    public ResponseEntity<BreedInfo> info(@RequestBody InfoBody infoBody) {
        BreedInfo breedInfo = breedInfoUseCase.getInfo(infoBody.breed);
        return new ResponseEntity<>(breedInfo, HttpStatus.OK);
    }
}

