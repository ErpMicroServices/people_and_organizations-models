package org.erp_microservices.people_and_organizations.models.facility.model;

import erp_microservices.fields.DateTimeRange;
import erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.party.model.contactmechanism.ContactMechanism;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:29 AM
 * @see "Data Model Resource Book Volume 1 Figure 2.11, page 59"
 */
@SuppressWarnings("serial")
@Entity
public class FacilityContactMechanism extends PersistentEntity {

	@NotNull
	@ManyToOne
	private Facility mechansimToContact;

	@NotNull
	@ManyToOne
	private ContactMechanism specifiedVia;

	@Embedded
	private DateTimeRange dateTimeRange = new DateTimeRange();


	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}


	public Facility getMechansimToContact() {
		return mechansimToContact;
	}

	public void setMechansimToContact(Facility mechansimToContact) {
		this.mechansimToContact = mechansimToContact;
	}

	public ContactMechanism getSpecifiedVia() {
		return specifiedVia;
	}

	public void setSpecifiedVia(ContactMechanism specifiedVia) {
		this.specifiedVia = specifiedVia;
	}

}