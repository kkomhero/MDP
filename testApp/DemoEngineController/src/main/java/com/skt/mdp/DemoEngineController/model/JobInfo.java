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
 * 작업 요청 세부 정보
 */
@ApiModel(description = "작업 요청 세부 정보 ")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobInfo {

  @JsonProperty("mdpJobId")
  private String mdpJobId = null;

  /**
   * episodeInfo
   *
   * @return episodeInfo
   **/
  @JsonProperty("episodeInfo")
  private EpisodeInfo episodeInfo = null;
  /**
   * episodeMetaInfo
   *
   * @return episodeMetaInfo
   **/
  @JsonProperty("episodeMetaInfo")
  private EpisodeMetaInfo episodeMetaInfo = null;
  /**
   * seriesMetaInfo
   *
   * @return seriesMetaInfo
   **/
  @JsonProperty("seriesMetaInfo")
  private SeriesMetaInfo seriesMetaInfo = null;

  @JsonProperty("workflowType")
  private String workflowType = null;

} // end class : JobInfo