package com.nausheen.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.nausheen.eventmanagement.entity.Participant;

public interface EventRepository extends CrudRepository<Participant, Long> {

}
