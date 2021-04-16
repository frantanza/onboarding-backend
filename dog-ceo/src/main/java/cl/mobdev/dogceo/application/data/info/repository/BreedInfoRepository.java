package cl.mobdev.dogceo.application.data.info.repository;

import cl.mobdev.dogceo.application.domain.model.BreedInfo;

public interface BreedInfoRepository {
    public BreedInfo getInfo(String breed);
}