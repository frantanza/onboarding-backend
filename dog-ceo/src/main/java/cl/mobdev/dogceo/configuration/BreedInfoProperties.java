package cl.mobdev.dogceo.configuration;

import org.springframework.beans.factory.annotation.Value;

public class BreedInfoProperties {
    @Value("${dog-ceo_api.base_url}")
    private String baseURL;
    
    @Value("${dog-ceo_api.endpoints.breed_info}")
    private String breedInfoEndpoint;

    @Value("${dog-ceo_api.endpoints.breed_images}")
    private String breedImagesEndpoint;

    public String getBreedInfoURL(String breed) {
        return baseURL.concat(breedInfoEndpoint).replace("{breed_name}", breed);
    }
    public String getImagesURL(String breed) {
        return baseURL.concat(breedImagesEndpoint).replace("{breed_images}", breed);
    }

}
