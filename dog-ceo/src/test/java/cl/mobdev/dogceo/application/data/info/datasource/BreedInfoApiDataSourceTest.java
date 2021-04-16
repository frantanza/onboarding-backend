package cl.mobdev.dogceo.application.data.info.datasource;

import cl.mobdev.dogceo.application.data.info.entity.BreedInfoEntity;
import cl.mobdev.dogceo.configuration.BreedInfoProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class BreedInfoApiDataSourceTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedInfoApiDataSource sut;
    private BreedInfoEntity breedInfoEntityMock;

    @Mock
    private RestOperations restOperations;
    @Mock
    private BreedInfoProperties breedInfoProperties;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new BreedInfoApiDataSource(restOperations, breedInfoProperties);

        breedInfoEntityMock = new BreedInfoEntity();
        breedInfoEntityMock.status = DATA_STATUS;
        breedInfoEntityMock.message = new ArrayList<>();
        breedInfoEntityMock.message.add(DATA_SUBBREED_1);
        breedInfoEntityMock.message.add(DATA_SUBBREED_2);
        breedInfoEntityMock.message.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnBreedInfoEntity_whenRequestIsExecuted() {
        when(restOperations.getForObject(
                breedInfoProperties.getBreedInfoURL(BREED_NAME),
                BreedInfoEntity.class
                )
        ).thenReturn(breedInfoEntityMock);

        BreedInfoEntity breedInfoEntity = sut.getInfo(BREED_NAME);

        Assertions.assertEquals(breedInfoEntityMock.message.stream().count(), breedInfoEntity.message.stream().count());
        Assertions.assertEquals(DATA_STATUS, breedInfoEntity.status);
    }
}