package com.doodle.polls.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Location {

	private String name;

	private String address;

	private String countryCode;

	private String locationId;

}

