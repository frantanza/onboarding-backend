package cl.mobdev.dogceo.application.presentation;

import cl.mobdev.dogceo.application.domain.model.BreedInfo;
import cl.mobdev.dogceo.application.domain.usecase.BreedInfoUseCase;
import cl.mobdev.dogceo.application.presentation.body.InfoBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BreedDetailControllerTest {

    private BreedDetailController sut;
    private BreedInfo breedInfoMock;
    private InfoBody infoBody;
    private final String DATA_BREED_NAME = "bulldog";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    @Mock
    private BreedInfoUseCase breedInfoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedDetailController(breedInfoUseCase);

        infoBody = new InfoBody();
        infoBody.breed = DATA_BREED_NAME;

        breedInfoMock = new BreedInfo();
        breedInfoMock.subBreeds = new ArrayList<>();
        breedInfoMock.subBreeds.add(DATA_SUBBREED_1);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_2);
        breedInfoMock.subBreeds.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedInfo_whenIsCalled() {
        when(breedInfoUseCase.getInfo(DATA_BREED_NAME)).thenReturn(breedInfoMock);

        ResponseEntity<BreedInfo> responseEntity = sut.info(infoBody);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
    }
}