package cl.mobdev.dogceo.application.data.info.datasource;

import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;

public interface BreedInfoDataSource {
    BreedInfoEntity getInfo(String breed);
}
