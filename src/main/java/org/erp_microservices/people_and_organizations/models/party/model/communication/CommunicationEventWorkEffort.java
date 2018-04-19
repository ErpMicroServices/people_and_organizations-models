package org.erp_microservices.people_and_organizations.models.party.model.communication;

import erp_microservices.model.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class CommunicationEventWorkEffort extends PersistentEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Lob
	private String description;

	/**
	 * The UUID for the work effort for this communication event.
	 */
	private UUID effortFor;

	@ManyToOne
	private CommunicationEvent eventFrom;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getEffortFor() {
		return effortFor;
	}

	public void setEffortFor(UUID effortFor) {
		this.effortFor = effortFor;
	}

	public CommunicationEvent getEventFrom() {
		return eventFrom;
	}

	public void setEventFrom(CommunicationEvent eventFrom) {
		this.eventFrom = eventFrom;
	}

}
