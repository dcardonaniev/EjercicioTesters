package it.bootcamp.ejerciciotesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
    @JsonProperty("id_case")
    private Long idCase;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tested")
    private Boolean tested;
    @JsonProperty("passed")
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
