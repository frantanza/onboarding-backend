package cl.mobdev.dogceo.application.data.info.mapper;

import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.common.Mapper;

public class BreedInfoToBreedInfoEntityMapper extends Mapper<BreedInfo, BreedInfoEntity> {

    @Override
    public BreedInfoEntity map(BreedInfo value) {
        return null;
    }

    @Override
    public BreedInfo reverseMap(BreedInfoEntity value) {
        BreedInfo breedInfo = new BreedInfo();
        breedInfo.subBreeds = value.message;
        return breedInfo;
    }
}
