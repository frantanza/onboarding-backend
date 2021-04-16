package cl.mobdev.dogceo.application.domain.usecase;

import cl.mobdev.dogceo.application.data.info.repository.BreedInfoRepository;
import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BreedInfoUseCaseTest {

    private BreedInfoUseCase sut;
    private BreedInfo breedInfoMock;

    private final String DATA_BREED_NAME = "bulldog";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    @Mock
    private BreedInfoRepository breedInfoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedInfoUseCase(breedInfoRepository);

        breedInfoMock = new BreedInfo();
        breedInfoMock.subBreeds = new ArrayList<>();
        breedInfoMock.subBreeds.add(DATA_SUBBREED_1);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_2);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedInfo_whenIsCalled() {
        when(breedInfoRepository.getInfo(DATA_BREED_NAME)).thenReturn(breedInfoMock);

        BreedInfo breedInfo = sut.getInfo(DATA_BREED_NAME);

        Assertions.assertEquals(breedInfoMock.subBreeds.stream().count(), breedInfo.subBreeds.stream().count());
        Assertions.assertEquals(breedInfoMock.subBreeds.stream().findFirst(), breedInfo.subBreeds.stream().findFirst());
    }
}