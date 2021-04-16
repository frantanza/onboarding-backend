package cl.mobdev.dogceo.application.data.info.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BreedInfoEntity {
    @JsonProperty
    public List<String> message;
    @JsonProperty
    public String status;
}
