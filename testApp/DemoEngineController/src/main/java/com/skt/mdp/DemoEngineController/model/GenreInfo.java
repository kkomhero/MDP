package com.skt.mdp.DemoEngineController.model;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 장르 정보
 */
@ApiModel(description = "장르 정보 ")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreInfo {
    /**
     * 장르ID
     *
     * @return genreId
     **/
    @JsonProperty("genreId")
    private String genreId = null;

//  @JsonProperty("mdpGenreId")
//  private String mdpGenreId = null;

    /**
     * 메타장르명
     *
     * @return genreName
     **/
    @JsonProperty("genreName")
    private String genreName = null;
    /**
     * 대표장르여부
     *
     * @return representative
     **/
    @JsonProperty("representative")
    private Boolean representative = null;

} // end class : GenreInfo