package com.test.springdataauditing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest<T> {

	@JsonProperty(value = "userId",required=true)
	private String loggedInuser;
	private String timezone;
	private T Employee;

}
