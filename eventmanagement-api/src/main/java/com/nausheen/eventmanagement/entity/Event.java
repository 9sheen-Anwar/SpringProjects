package com.nausheen.eventmanagement.entity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"started"})
@Entity
public class Event extends AbstractEntity {
	private String name;
	private String desciption;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private ZoneId zoneId;
	private Boolean started;
	@ManyToOne(fetch=FetchType.EAGER)//when organizer is deleted all its event is also deleted
	@JoinColumn(nullable=false)
	private Organizer organizer;
	@OneToMany(mappedBy="Events", fetch=FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval=true)//if the association is removed  then participant will be deleted
	private Set<Participant> participant;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@RestResource(exported=false)
	private Venue venue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	public ZoneId getZoneId() {
		return zoneId;
	}
	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}
	public Boolean getStarted() {
		return started;
	}
	public void setStarted(Boolean started) {
		this.started = started;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public Set<Participant> getParticipant() {
		return participant;
	}
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return Objects.equals(id,((Event)obj).id);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id) ;
	}
	
}
