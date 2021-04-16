package cl.mobdev.dogceo.application.data.info.datasource;

import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.configuration.BreedInfoProperties;
import org.springframework.web.client.RestOperations;

public class BreedInfoApiDataSource implements BreedInfoDataSource {

    private final RestOperations restOperations;
    private final BreedInfoProperties breedInfoProperties;

    public BreedInfoApiDataSource(
            RestOperations restOperations,
            BreedInfoProperties breedInfoProperties
    ) {
        this.restOperations = restOperations;
        this.breedInfoProperties = breedInfoProperties;
    }

    @Override
    public BreedInfoEntity getInfo(String breed) {
        return restOperations.getForObject(breedInfoProperties.getBreedInfoURL(breed), BreedInfoEntity.class);
    }
}
