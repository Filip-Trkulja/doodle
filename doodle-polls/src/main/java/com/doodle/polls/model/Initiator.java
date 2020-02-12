package com.doodle.polls.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Initiator {

	private String name;

	private String email;

	private Boolean notify;

	private String timeZone;

}

