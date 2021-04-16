package cl.mobdev.dogceo.application.data.info.datasource;

import cl.mobdev.dogceo.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceo.configuration.BreedInfoProperties;
import org.springframework.web.client.RestOperations;

public class BreedImagesApiDataSource implements BreedImagesDataSource {

    private final RestOperations restOperations;
    private final BreedInfoProperties breedInfoProperties;

    public BreedImagesApiDataSource(RestOperations restOperations, BreedInfoProperties breedInfoProperties) {
        this.restOperations = restOperations;
        this.breedInfoProperties = breedInfoProperties;
    }
    @Override
    public BreedImagesEntity getImages(String breed){
        return restOperations.getForObject(breedInfoProperties.getImagesURL(breed),BreedImagesEntity.class);
    }
}
