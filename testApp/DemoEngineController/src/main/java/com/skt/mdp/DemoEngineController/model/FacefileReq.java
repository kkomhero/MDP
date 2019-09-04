package com.skt.mdp.DemoEngineController.model;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacefileReq {

    @JsonProperty("reusltPath")
    private String reusltPath;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("mdpJobId")
    private String mdpJobId;
    
}
