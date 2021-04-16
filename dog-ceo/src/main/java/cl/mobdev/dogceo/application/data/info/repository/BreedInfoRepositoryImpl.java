package cl.mobdev.dogceo.application.data.info.repository;

import cl.mobdev.dogceo.application.data.info.datasource.BreedInfoDataSource;
import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.common.Mapper;

public class BreedInfoRepositoryImpl implements BreedInfoRepository {

    private final Mapper<BreedInfo, BreedInfoEntity> breedInfoBreedInfoEntityMapper;
    private final BreedInfoDataSource breedInfoDataSource;

    public BreedInfoRepositoryImpl(
            Mapper<BreedInfo, BreedInfoEntity> breedInfoBreedInfoEntityMapper,
            BreedInfoDataSource breedInfoDataSource
    ) {
        this.breedInfoBreedInfoEntityMapper = breedInfoBreedInfoEntityMapper;
        this.breedInfoDataSource = breedInfoDataSource;
    }

    @Override
    public BreedInfo getInfo(String breed) {
        BreedInfoEntity breedInfoEntity = breedInfoDataSource.getInfo(breed);
        BreedInfo breedInfo = breedInfoBreedInfoEntityMapper.reverseMap(breedInfoEntity);
        return breedInfo;
    }
}