package cl.mobdev.dogceo.application.presentation;

import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceo.application.domain.usecase.BreedImagesUseCase;
import cl.mobdev.dogceo.application.presentation.body.InfoBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BreedImagesController implements BreedImages{

    private final BreedImagesUseCase breedImagesUseCase;

    public BreedImagesController(BreedImagesUseCase breedImagesUseCase) {
        this.breedImagesUseCase = breedImagesUseCase;
    }

    @Override
    public ResponseEntity<BreedImagesModel> images(@RequestBody InfoBody infoBody) {
        BreedImagesModel breedImagesModel = breedImagesUseCase.getImages(infoBody.breed);
        return new ResponseEntity<>(breedImagesModel, HttpStatus.OK);
    }
}
