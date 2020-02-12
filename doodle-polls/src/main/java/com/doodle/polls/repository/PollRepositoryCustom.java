package com.doodle.polls.repository;

import java.util.Date;
import java.util.List;
import com.doodle.polls.model.Poll;

public interface PollRepositoryCustom {

	List<Poll> findPollsByEmailAndCriterias(String email, String text, Date sinceDate);

	List<Poll> findPollsByCriterias(String text, Date sinceDate);

}
