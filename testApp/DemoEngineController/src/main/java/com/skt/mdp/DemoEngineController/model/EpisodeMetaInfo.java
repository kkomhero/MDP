package com.skt.mdp.DemoEngineController.model;

import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 에피소드 메타 정보
 */
@ApiModel(description = "에피소드 메타 정보 ")
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeMetaInfo {
    /**
     * 방송일자
     *
     * @return broadcastDate
     **/
    @JsonProperty("broadcastDate")
    private String broadcastDate = null;
    /**
     * 방송회차
     *
     * @return sequenceNumber
     **/
    @JsonProperty("sequenceNumber")
    private Integer sequenceNumber = null;

    @JsonProperty("manufactureContryNames")
    @Valid
    /**
     * 제작국가
     *
     * @return manufactureCountryNames
     **/
    private List<String> manufactureContryNames = null;
    /**
     * 제작년도
     *
     * @return manufactureYear
     **/
    @JsonProperty("manufactureYear")
    private String manufactureYear = null;
    /**
     * 제작사명
     *
     * @return manufactureCompanyName
     **/
    @JsonProperty("manufactureCompanyName")
    private String manufactureCompanyName = null;
    /**
     * 메타ID
     *
     * @return metaId
     **/
    @JsonProperty("metaId")
    private String metaId = null;
    /**
     * 메타제목
     *
     * @return title
     **/
    @JsonProperty("title")
    private String title = null;
    /**
     * 메타유형
     *
     * @return metaTypeCode
     **/
    @JsonProperty("metaTypeCode")
    private String metaTypeCode = null;

    /**
     * 콘텐츠편성일
     *
     * @return openDate
     **/
    @JsonProperty("openDate")
    private String openDate = null;

    /**
     * 부제목
     *
     * @return subTitle
     **/
    @JsonProperty("subTitle")
    private String subTitle = null;

    /**
     * 시청등급
     *
     * @return filmRatingCode
     **/
    @JsonProperty("filmRatingCode")
    private Integer filmRatingCode = null;

    /**
     * 전체회차
     *
     * @return totalSequenceCount
     **/
    @JsonProperty("totalSequenceCount")
    private Integer totalSequenceCount = null;

    @JsonProperty("genreInfos")
    @Valid
    /**
     * Get genreInfos
     *
     * @return genreInfos
     **/
    private List<GenreInfo> genreInfos = null;

    @JsonProperty("peopleInfos")
    @Valid
    /**
     * Get peopleInfos
     *
     * @return peopleInfos
     **/
    @ApiModelProperty(value = "")
    private List<PeopleInfo> peopleInfos = null;

//  /**
//   * 시스템 내부에서 사용하는 메타ID
//   *
//   * @return mdpEpisodeMetaId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 메타ID")
//  @JsonProperty("mdpEpisodeMetaId")
//  private String mdpEpisodeMetaId = null;

//  /**
//   * 시스템 내부에서 사용하는 메타유형 ID
//   *
//   * @return mdpMetaTypeId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 메타유형 ID")
//  @JsonProperty("mdpMetaTypeId")
//  private String mdpMetaTypeId = null;

//  /**
//   * 시스템 내부에서 사용하는 Episode Id
//   *
//   * @return mdpEpisodeId
//   **/
//  @ApiModelProperty(value = "시스템 내부에서 사용하는 Episode Id")
//  @JsonProperty("mdpEpisodeId")
//  private String mdpEpisodeId = null;

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

} // end class : EpisodeMetaInfo