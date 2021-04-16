package cl.mobdev.dogceo.application.data.info.repository;

import cl.mobdev.dogceo.application.data.info.datasource.BreedInfoDataSource;
import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.common.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BreedInfoRepositoryImplTest {

    private final String DATA_BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedInfoEntity breedInfoEntityMock;
    private BreedInfo breedInfoMock;

    private BreedInfoRepositoryImpl sut;

    @Mock
    private BreedInfoDataSource breedInfoDataSource;
    @Mock
    private Mapper<BreedInfo, BreedInfoEntity> breedInfoBreedInfoEntityMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new BreedInfoRepositoryImpl(breedInfoBreedInfoEntityMapper, breedInfoDataSource);

        breedInfoEntityMock = new BreedInfoEntity();
        breedInfoEntityMock.status = DATA_STATUS;
        breedInfoEntityMock.message = new ArrayList<>();
        breedInfoEntityMock.message.add(DATA_SUBBREED_1);
        breedInfoEntityMock.message.add(DATA_SUBBREED_2);
        breedInfoEntityMock.message.add(DATA_SUBBREED_3);

        breedInfoMock = new BreedInfo();
        breedInfoMock.subBreeds = new ArrayList<>();
        breedInfoMock.subBreeds.add(DATA_SUBBREED_1);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_2);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedInfo_whenGetBreedInfoIsCalled() {
        when(breedInfoDataSource.getInfo(DATA_BREED_NAME)).thenReturn(breedInfoEntityMock);
        when(breedInfoBreedInfoEntityMapper.reverseMap(breedInfoEntityMock)).thenReturn(breedInfoMock);

        BreedInfo breedInfo = sut.getInfo(DATA_BREED_NAME);

        Assertions.assertEquals(breedInfoMock.subBreeds.stream().count(), breedInfo.subBreeds.stream().count());
        Assertions.assertEquals(breedInfoMock.subBreeds.stream().findFirst(), breedInfo.subBreeds.stream().findFirst());
    }
}