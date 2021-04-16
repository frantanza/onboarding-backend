package cl.mobdev.dogceo.application.data.info.mapper;

import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BreedInfoToBreedInfoEntityMapperTest {

    private BreedInfoToBreedInfoEntityMapper sut;
    private BreedInfoEntity breedInfoEntityMock;
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    @BeforeEach
    void setUp() {
        sut = new BreedInfoToBreedInfoEntityMapper();

        breedInfoEntityMock = new BreedInfoEntity();
        breedInfoEntityMock = new BreedInfoEntity();
        breedInfoEntityMock.status = DATA_STATUS;
        breedInfoEntityMock.message = new ArrayList<>();
        breedInfoEntityMock.message.add(DATA_SUBBREED_1);
        breedInfoEntityMock.message.add(DATA_SUBBREED_2);
        breedInfoEntityMock.message.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedInfo_whenReverseMapIsCalled() {
        BreedInfo breedInfo = sut.reverseMap(breedInfoEntityMock);

        Assertions.assertEquals(breedInfoEntityMock.message.stream().count(), breedInfo.subBreeds.stream().count());
    }

}