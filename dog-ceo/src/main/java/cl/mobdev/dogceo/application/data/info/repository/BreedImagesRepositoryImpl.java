package cl.mobdev.dogceo.application.data.info.repository;

import cl.mobdev.dogceo.application.data.info.datasource.BreedImagesDataSource;
import cl.mobdev.dogceo.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceo.common.Mapper;

public class BreedImagesRepositoryImpl implements BreedImagesRepository{
    private final Mapper<BreedImagesModel,BreedImagesEntity> breedImagesBreedImagesEntityMapper;
    private final BreedImagesDataSource breedImagesDataSource;

    public BreedImagesRepositoryImpl(
            Mapper<BreedImagesModel, BreedImagesEntity> breedImagesBreedImagesEntityMapper,
            BreedImagesDataSource breedImagesDataSource
    ) {
        this.breedImagesBreedImagesEntityMapper = breedImagesBreedImagesEntityMapper;
        this.breedImagesDataSource = breedImagesDataSource;
    }

    @Override
    public BreedImagesModel getImages(String breed){
        BreedImagesEntity breedImagesEntity = breedImagesDataSource.getImages(breed);
        BreedImagesModel breedImagesModel = breedImagesBreedImagesEntityMapper.reverseMap(breedImagesEntity);
        return breedImagesModel;
    }
}
