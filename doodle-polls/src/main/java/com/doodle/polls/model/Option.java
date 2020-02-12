package com.doodle.polls.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Option {

	@TextIndexed
	private String text;

	private Boolean available;

	private Long start;

	private Long end;

	private Long startDate;

	private Long endDate;

	private Long startDateTime;

	private Long endDateTime;

	private Boolean allday;

	private Long date;

	private Long dateTime;

}
