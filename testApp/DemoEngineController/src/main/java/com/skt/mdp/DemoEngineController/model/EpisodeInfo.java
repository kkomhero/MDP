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
 * 에피소드 정보
 */
@ApiModel(description = "에피소드 정보 ")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeInfo {

  /**
   * 에피소드 Id
   *
   * @return episodeId
   **/
  @JsonProperty("episodeId")
  private String episodeId = null;

  /**
   * Content ID
   *
   * @return resolutionId
   **/
  @JsonProperty("resolutionId")
  private String resolutionId = null;

  /**
   * 파일경로 URL
   *
   * @return filePath
   **/
  @JsonProperty("filePath")
  private String filePath = null;

  /**
   * 재생시간 (초)
   *
   * @return playingTime
   **/
  @JsonProperty("playingTime")
  private Integer playingTime = null;

  /**
   * Content 파일명
   *
   * @return resolutionFileName
   **/
  @JsonProperty("resolutionFileName")
  private String resolutionFileName = null;

  /**
   * 시리즈 ID
   *
   * @return seriesId
   **/
  @JsonProperty("seriesId")
  private String seriesId = null;

  /**
   * 시리즈 명
   *
   * @return seriesName
   **/
  @JsonProperty("seriesName")
  private String seriesName = null;

  /**
   * 수집 타입 (Http, Ftp, s3...)
   *
   * @return contentCollectType
   **/
  @JsonProperty("dataSourceTypeCode")
  private String dataSourceTypeCode = null;

//  /**
//   * 시스템 내부에서 사용하는 Episode Id
//   *
//   * @return mdpEpisodeId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 Episode Id")
//  @JsonProperty("mdpEpisodeId")
//  private String mdpEpisodeId = null;

//  /**
//   * 시스템 내부에서 사용하는 시리즈 ID
//   *
//   * @return mdpSeriesId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 시리즈 ID")
//  @JsonProperty("mdpSeriesId")
//  private String mdpSeriesId = null;


  /**
   * 마스터ID
   *
   * @return masterId
   **/
  @JsonProperty("masterId")
  private String masterId = null;

//  /**
//   * 시스템 내부에서 사용하는 마스터ID
//   *
//   * @return mdpMasterId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 마스터ID")
//  @JsonProperty("mdpMasterId")
//  private String mdpMasterId = null;

//  /**
//   * 시스템 내부에서 사용하는 Content ID
//   *
//   * @return mdpResolutionId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 Content ID")
//  @JsonProperty("mdpResolutionId")
//  private String mdpResolutionId = null;

  @JsonProperty("contentType")
  private String contentType = null;

} // end class : EpisodeInfo
