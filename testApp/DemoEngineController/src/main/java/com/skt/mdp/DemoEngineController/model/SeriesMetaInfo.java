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
 * 시리즈 메타 정보
 */
@ApiModel(description = "시리즈 메타 정보 ")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeriesMetaInfo {
    /**
     * 시리즈 메타ID
     *
     * @return seriesMetaId
     **/
    @JsonProperty("seriesMetaId")
    private String seriesMetaId = null;

//  /**
//   * 시스템 내부에서 사용하는 시리즈ID
//   *
//   * @return mdpSeriesId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 시리즈ID")
//  @JsonProperty("mdpSeriesId")
//  private String mdpSeriesId = null;

//  /**
//   * 시스템 내부에서 사용하는 마스터ID
//   *
//   * @return mdpMasterId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 마스터ID")
//  @JsonProperty("mdpMasterId")
//  private String mdpMasterId = null;

//  /**
//   * 시스템 내부에서 사용하는 시리즈 메타 ID
//   *
//   * @return mdpSeriesMetaId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 시리즈 메타 ID")
//  @JsonProperty("mdpSeriesMetaId")
//  private String mdpSeriesMetaId = null;

} // end class : SeriesMetaInfo