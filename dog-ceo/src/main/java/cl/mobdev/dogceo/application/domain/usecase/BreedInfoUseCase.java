package cl.mobdev.dogceo.application.domain.usecase;

import cl.mobdev.dogceo.application.data.info.repository.BreedInfoRepository;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;

public class BreedInfoUseCase {

    private final BreedInfoRepository breedInfoRepository;

    public BreedInfoUseCase(BreedInfoRepository breedInfoRepository) {
        this.breedInfoRepository = breedInfoRepository;
    }

    public BreedInfo getInfo(String breed) {
        return breedInfoRepository.getInfo(breed);
    }
}
