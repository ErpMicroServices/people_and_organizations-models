package org.erp_microservices.people_and_organizations.models.party.model.communication;

import org.erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.party.model.PartyContactMechanism;
import org.erp_microservices.people_and_organizations.models.party.model.relationship.PartyRelationship;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a communication between two or more parties.
 *
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:27 AM
 * @see "Data Model Resource Book Volume 1 Figure 2.7, Page 48"
 * @see "Data Model Resource Book Volume 1 Figure 2.12, page 60"
 * @see "Data Model Resource Book Volume 1 Figure 2.13, page 64"
 */
@SuppressWarnings("serial")
@Entity
public class CommunicationEvent extends PersistentEntity {

	@ManyToMany
	private List<Case> asPartOf = new ArrayList<Case>();

	@OneToMany
	private List<CommunicationEventPurpose> categorizedBy = new ArrayList<CommunicationEventPurpose>();

	private ZonedDateTime dateTimeEnded;

	@NotNull
	private ZonedDateTime dateTimeStarted;

	@ManyToOne
	private PartyRelationship inTheContextOf;

	@OneToMany(mappedBy = "of", cascade = CascadeType.ALL)
	private List<CommunicationEventRole> involving = new ArrayList<CommunicationEventRole>();

	@ManyToOne
	private CommunicationEventStatusType monitoredBy;

	@NotEmpty
	@Lob
	private String note;

	@ManyToOne
	private PartyContactMechanism occursVia;

	public void addCommunicationEventRole(CommunicationEventRole communicationEventRole) {
		if (!getInvolving().contains(communicationEventRole)) {
			getInvolving().add(communicationEventRole);
			communicationEventRole.setOf(this);
		}

	}

	/**
	 * @return the involving
	 */
	public List<CommunicationEventRole> getInvolving() {
		return involving;
	}

	/**
	 * @param involving the involving to set
	 */
	public void setInvolving(List<CommunicationEventRole> involving) {
		this.involving = involving;
	}

	/**
	 * @return the asPartOf
	 */
	public List<Case> getAsPartOf() {
		return asPartOf;
	}

	/**
	 * @param asPartOf the asPartOf to set
	 */
	public void setAsPartOf(List<Case> asPartOf) {
		this.asPartOf = asPartOf;
	}

	/**
	 * @return the categorizedBy
	 */
	public List<CommunicationEventPurpose> getCategorizedBy() {
		return categorizedBy;
	}

	/**
	 * @param categorizedBy the categorizedBy to set
	 */
	public void setCategorizedBy(List<CommunicationEventPurpose> categorizedBy) {
		this.categorizedBy = categorizedBy;
	}

	/**
	 * @return the dateTimeEnded
	 */

	public ZonedDateTime getDateTimeEnded() {
		return dateTimeEnded;
	}

	/**
	 * @param dateTimeEnded the dateTimeEnded to set
	 */
	public void setDateTimeEnded(ZonedDateTime dateTimeEnded) {
		this.dateTimeEnded = dateTimeEnded;
	}

	/**
	 * @return the dateTimeStarted
	 */
	public ZonedDateTime getDateTimeStarted() {
		return dateTimeStarted;
	}

	/**
	 * @param dateTimeStarted the dateTimeStarted to set
	 */
	public void setDateTimeStarted(ZonedDateTime dateTimeStarted) {
		this.dateTimeStarted = dateTimeStarted;
	}

	/**
	 * @return the inTheContextOf
	 */
	public PartyRelationship getInTheContextOf() {
		return inTheContextOf;
	}

	/**
	 * @param inTheContextOf the inTheContextOf to set
	 */
	public void setInTheContextOf(PartyRelationship inTheContextOf) {
		this.inTheContextOf = inTheContextOf;
	}

	/**
	 * @return the monitoredBy
	 */
	public CommunicationEventStatusType getMonitoredBy() {
		return monitoredBy;
	}

	/**
	 * @param monitoredBy the monitoredBy to set
	 */
	public void setMonitoredBy(CommunicationEventStatusType monitoredBy) {
		this.monitoredBy = monitoredBy;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the occursVia
	 */
	public PartyContactMechanism getOccursVia() {
		return occursVia;
	}

	// public void addCase(Case newCase) {
	// getAsPartOf().add(newCase);
	// newCase.getEncompassing().add(this);
	// }

	/**
	 * @param occursVia the occursVia to set
	 */
	public void setOccursVia(PartyContactMechanism occursVia) {
		this.occursVia = occursVia;
	}

	@Transient
	@AssertTrue
	public boolean isRangeValid() {
		if (dateTimeEnded != null) {
			return true;
		} else {
			return dateTimeEnded.isAfter(dateTimeStarted);
		}
	}
}