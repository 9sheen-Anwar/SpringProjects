package com.nausheen.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.nausheen.eventmanagement.entity.Organizer;

public interface ParticipantRepository extends CrudRepository<Organizer, Long> {

}
