package cl.mobdev.dogceo.configuration;

import cl.mobdev.dogceo.application.data.info.datasource.BreedInfoApiDataSource;
import cl.mobdev.dogceo.application.data.info.datasource.BreedInfoDataSource;
import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.application.data.info.mapper.BreedInfoToBreedInfoEntityMapper;
import cl.mobdev.dogceo.application.data.info.repository.BreedInfoRepository;
import cl.mobdev.dogceo.application.data.info.repository.BreedInfoRepositoryImpl;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.application.domain.usecase.BreedInfoUseCase;
import cl.mobdev.dogceo.application.presentation.BreedDetail;
import cl.mobdev.dogceo.application.presentation.BreedDetailController;
import cl.mobdev.dogceo.common.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BreedInfoConfiguration {

    // Presentation
    @Bean
    BreedDetail breedDetail(BreedInfoUseCase breedInfoUseCase) {
        return new BreedDetailController(breedInfoUseCase);
    }

    // Domain

    @Bean
    BreedInfoUseCase breedInfoUseCase(BreedInfoRepository breedInfoRepository) {
        return new BreedInfoUseCase(breedInfoRepository);
    }

    @Bean
    BreedInfoRepository breedInfoRepository(
            Mapper<BreedInfo, BreedInfoEntity> breedInfoBreedInfoEntityMapper,
            BreedInfoDataSource breedInfoDataSource
    ) {
        return new BreedInfoRepositoryImpl(breedInfoBreedInfoEntityMapper, breedInfoDataSource);
    }

    @Bean
    Mapper<BreedInfo, BreedInfoEntity> breedInfoBreedInfoEntityMapper() {
        return new BreedInfoToBreedInfoEntityMapper();
    }

    // Data

    @Bean
    BreedInfoDataSource breedInfoDataSource(
            RestOperations restOperations,
            BreedInfoProperties breedInfoProperties
    ) {
        return new BreedInfoApiDataSource(restOperations, breedInfoProperties);
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
