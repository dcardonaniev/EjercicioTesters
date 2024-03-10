package it.bootcamp.ejerciciotesters.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestCaseDTO {
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
