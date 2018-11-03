package org.erp_microservices.people_and_organizations.models.party.model.relationship;

import org.erp_microservices.people_and_organizations.models.party.model.PartyRole;

import javax.persistence.Entity;


@Entity
public class OrganizationRollup extends PartyRelationship {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PartyRole getRelationshipFrom() {
		return super.getRelationshipFrom();
	}

	public void setRelationshipFrom(PartyRole relationshipFrom) {
		super.setRelationshipFrom(relationshipFrom);
	}

	public PartyRole getRelationshipTo() {
		return super.getRelationshipTo();
	}

	public void setRelationshipTo(PartyRole relationshipTo) {
		super.setRelationshipTo(relationshipTo);
	}
}
