package com.doodle.polls.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.doodle.polls.model.Poll;

public interface PollRepository extends MongoRepository<Poll, String>, PollRepositoryCustom {

}
