package org.erp_microservices.people_and_organizations.models.party.model;

import org.erp_microservices.fields.DateTimeRange;
import org.erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.party.model.contactmechanism.PostalAddress;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

/**
 * Association class between Party and PostalAddress classes, since these could
 * be a many to many relationship, and we might need/want to track address
 * history.
 *
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:33 AM
 * @see Data Model Resource Book Volume 1 Figure 2.8, page 50
 */
@SuppressWarnings("serial")
@Entity
public class PartyPostalAddress extends PersistentEntity {

	@Lob
	private String comment;

	@ManyToOne
	private PostalAddress locatedAt;

	@ManyToOne
	private Party specifiedFor;

	@Embedded
	private DateTimeRange dateTimeRange = new DateTimeRange();


	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PostalAddress getLocatedAt() {
		return locatedAt;
	}

	public void setLocatedAt(PostalAddress locatedAt) {
		this.locatedAt = locatedAt;
	}

	public Party getSpecifiedFor() {
		return specifiedFor;
	}

	public void setSpecifiedFor(Party specifiedFor) {
		this.specifiedFor = specifiedFor;
	}

}