package cl.mobdev.dogceo.configuration;

import cl.mobdev.dogceo.application.data.info.datasource.BreedImagesApiDataSource;
import cl.mobdev.dogceo.application.data.info.datasource.BreedImagesDataSource;
import cl.mobdev.dogceo.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceo.application.data.info.mapper.BreedImagesToEntityMapper;
import cl.mobdev.dogceo.application.data.info.repository.BreedImagesRepository;
import cl.mobdev.dogceo.application.data.info.repository.BreedImagesRepositoryImpl;
import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceo.application.domain.usecase.BreedImagesUseCase;
import cl.mobdev.dogceo.application.presentation.BreedImages;
import cl.mobdev.dogceo.application.presentation.BreedImagesController;
import cl.mobdev.dogceo.common.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BreedImagesConfiguration {
    // Presentation
    @Bean
    BreedImages breedImages(BreedImagesUseCase breedImagesUseCase) {
        return new BreedImagesController(breedImagesUseCase);
    }

    // Domain

    @Bean
    BreedImagesUseCase breedImagesUseCase(BreedImagesRepository breedImagesRepository) {
        return new BreedImagesUseCase(breedImagesRepository);
    }

    @Bean
    BreedImagesRepository breedImagesRepository(
            Mapper<BreedImagesModel, BreedImagesEntity> breedImagesModelBreedImagesEntityMapper,
            BreedImagesDataSource breedImagesDataSource
    ) {
        return new BreedImagesRepositoryImpl(breedImagesModelBreedImagesEntityMapper, breedImagesDataSource);
    }

    @Bean
    Mapper<BreedImagesModel, BreedImagesEntity>BreedImagesToEntityMapper(){
        return new BreedImagesToEntityMapper();
    }

    // Data

    @Bean
    BreedImagesDataSource breedImagesDataSource(
            RestOperations restOperations,
            BreedInfoProperties breedInfoProperties
    ) {
        return new BreedImagesApiDataSource(restOperations, breedInfoProperties);
    }

    @Bean
    BreedInfoProperties breedInfoProperties() {
        return new BreedInfoProperties();
    }

    // Frameworks

    @Bean
    RestOperations restOperations() {
        return new RestTemplate();
    }
}

