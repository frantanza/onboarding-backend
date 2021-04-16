package cl.mobdev.dogceo.application.data.info.datasource;
import cl.mobdev.dogceo.application.data.info.entity.BreedImagesEntity;

public interface BreedImagesDataSource {
    BreedImagesEntity getImages(String breed);
}
