package com.doodle.polls.model;

import java.util.List;
import java.util.Locale;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Document(collection = "polls")
@JsonInclude(Include.NON_NULL)
public class Poll {

	public enum State {
		OPEN, CLOSED
	}

	public enum Type {
		TEXT, DATE
	}

	public enum PreferenceType {
		YESNO, YESNOIFNEEDBE
	}

	@Id
	private String id;

	private String adminKey;

	private Long latestChange;

	private Long initiated;

	private Integer participantsCount;

	private Integer inviteesCount;

	private Type type;

	private Integer rowConstraint;

	private Boolean timeZone;

	private Integer columnConstraint;

	private Boolean hidden;

	private PreferenceType preferencesType;

	private State state;

	private Locale locale;
	
	@TextIndexed
	private String title;

	private Location location;

	@TextIndexed
	private String description;

	private Initiator initiator;

	private List<Option> options;

	private String optionsHash;

	private List<Participant> participants;

	private List<Object> invitees;

	private Boolean multiDay;

	private Boolean dateText;

	private String device;

	private PreferenceType levels;

}
