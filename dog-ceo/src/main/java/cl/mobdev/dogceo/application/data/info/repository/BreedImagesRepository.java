package cl.mobdev.dogceo.application.data.info.repository;

import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;

public interface BreedImagesRepository {
    BreedImagesModel getImages(String breed);
}
