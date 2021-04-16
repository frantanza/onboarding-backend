package cl.mobdev.dogceo.application.data.info.mapper;

import cl.mobdev.dogceo.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceo.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceo.common.Mapper;

public class BreedImagesToEntityMapper extends Mapper<BreedImagesModel, BreedImagesEntity> {
    @Override
    public BreedImagesEntity map(BreedImagesModel value){
        return null;
    }

    @Override
    public BreedImagesModel reverseMap(BreedImagesEntity value){
        BreedImagesModel breedImagesModel = new BreedImagesModel();
        breedImagesModel.images = value.message;
        return breedImagesModel;

    }
}
