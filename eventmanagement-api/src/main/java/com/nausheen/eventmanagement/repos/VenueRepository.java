package com.nausheen.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.nausheen.eventmanagement.entity.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {

}
