package com.doodle.polls.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.util.StringUtils;

import com.doodle.polls.model.Poll;
import com.doodle.polls.repository.PollRepositoryCustom;

public class PollRepositoryImpl implements PollRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public PollRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Poll> findPollsByEmailAndCriterias(String email, String text, Date sinceDate) {
		Query query = new Query();

		if (StringUtils.hasText(text)) {
			TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
			query = TextQuery.queryText(criteria).sortByScore();
		}

		query.addCriteria(Criteria.where("initiator.email").is(email));

		if (sinceDate != null) {
			query.addCriteria(Criteria.where("initiated").gte(sinceDate.getTime()));
		}

		return mongoTemplate.find(query, Poll.class);
	}

	@Override
	public List<Poll> findPollsByCriterias(String text, Date sinceDate) {
		Query query = new Query();

		if (StringUtils.hasText(text)) {
			TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
			query = TextQuery.queryText(criteria).sortByScore();
		}

		if (sinceDate != null) {
			query.addCriteria(Criteria.where("initiated").gte(sinceDate.getTime()));
		}

		return mongoTemplate.find(query, Poll.class);
	}

}
