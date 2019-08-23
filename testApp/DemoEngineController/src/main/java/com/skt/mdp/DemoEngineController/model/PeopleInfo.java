package com.skt.mdp.DemoEngineController.model;

import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PeopleInfo
 */
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleInfo {
  /**
   * 생년월일
   *
   * @return birthday
   **/
  @JsonProperty("birthday")
  private String birthday = null;
  /**
   * 인물ID
   *
   * @return personId
   **/
  @JsonProperty("personId")
  private String personId = null;

//  @JsonProperty("mdpPersonId")
//  private String mdpPersonId = null;

  /**
   * 인물명
   *
   * @return personName
   **/
  @JsonProperty("personName")
  private String personName = null;
  /**
   * 인물역할
   *
   * @return roleCode
   **/
  @JsonProperty("roleCode")
  private String roleCode = null;
  /**
   * 성별
   *
   * @return sexCode
   **/
  @JsonProperty("sexCode")
  private String sexCode = null;
  /**
   * 정열순번
   *
   * @return sequence
   **/
  @JsonProperty("sequence")
  private Integer sequence = null;

  @Valid
  /**
   * 필모그래피
   *
   * @return filmography
   **/
  private List<String> filmography = null;

} // end class : PeopleInfo

