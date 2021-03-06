package org.erp_microservices.people_and_organizations.models.party.model;

import org.erp_microservices.fields.DateTimeRange;
import org.erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.party.model.contactmechanism.ContactMechanism;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Maps the relationship between a party and their contact mechanisms
 *
 * @author jim
 */
@SuppressWarnings("serial")
@Entity
public class PartyContactMechanism extends PersistentEntity {
	@Lob
	private String comment;

	@ManyToOne
	private Party mechanismToContact;

	private boolean solicitable = false;

	@ManyToOne
	private PartyRole specifiedFor;

	@ManyToOne
	private ContactMechanism specifiedVia;

	@OneToMany(mappedBy = "usedWithin")
	private List<PartyContactMechanismPurpose> usedForThePurposeOf = new ArrayList<PartyContactMechanismPurpose>();

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

	public Party getMechanismToContact() {
		return mechanismToContact;
	}

	public void setMechanismToContact(Party mechanismToConact) {
		this.mechanismToContact = mechanismToConact;
	}

	public PartyRole getSpecifiedFor() {
		return specifiedFor;
	}

	public void setSpecifiedFor(PartyRole specifiedFor) {
		this.specifiedFor = specifiedFor;
	}

	public ContactMechanism getSpecifiedVia() {
		return specifiedVia;
	}

	public void setSpecifiedVia(ContactMechanism mechanism) {
		this.specifiedVia = mechanism;
	}

	public List<PartyContactMechanismPurpose> getUsedForThePurposeOf() {
		return usedForThePurposeOf;
	}

	public void setUsedForThePurposeOf(List<PartyContactMechanismPurpose> usedForThePurposeOf) {
		this.usedForThePurposeOf = usedForThePurposeOf;
	}

	public boolean isSolicitable() {
		return solicitable;
	}

	public void setSolicitable(boolean solicitable) {
		this.solicitable = solicitable;
	}

}
