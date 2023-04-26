package com.nausheen.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import antlr.debug.Event;

public interface OrganizerRepository extends CrudRepository<Event, Long> {

}
