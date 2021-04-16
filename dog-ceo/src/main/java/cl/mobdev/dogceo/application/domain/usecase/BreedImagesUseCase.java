package cl.mobdev.dogceo.application.domain.usecase;

import cl.mobdev.dogceo.application.data.info.repository.BreedImagesRepository;
import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;

public class BreedImagesUseCase {

    private final BreedImagesRepository breedImagesRepository;

    public BreedImagesUseCase(BreedImagesRepository breedImagesRepository) {
        this.breedImagesRepository = breedImagesRepository;
    }

    public BreedImagesModel getImages(String breed){ return breedImagesRepository.getImages(breed);}
}
