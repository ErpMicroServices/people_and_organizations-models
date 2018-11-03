package org.erp_microservices.people_and_organizations.models.party.model.relationship;

import org.erp_microservices.people_and_organizations.models.party.model.roles.Customer;
import org.erp_microservices.people_and_organizations.models.party.model.roles.InternalOrganization;

import javax.persistence.Entity;

@Entity
public class CustomerRelationship extends PartyRelationship {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CustomerRelationship(InternalOrganization relationshipFrom, Customer relationshipTo) {
		super();
		setRelationshipFrom(relationshipFrom);
		setRelationshipTo(relationshipTo);
	}

	public void setRelationshipFrom(InternalOrganization relationshipFrom) {
		super.setRelationshipFrom(relationshipFrom);
	}

	public void setRelationshipTo(Customer relationshipTo) {
		super.setRelationshipTo(relationshipTo);
	}

	public CustomerRelationship() {
		super();
	}

	public InternalOrganization getRelationshipFrom() {
		return (InternalOrganization) super.getRelationshipFrom();
	}

	public Customer getRelationshipTo() {
		return (Customer) super.getRelationshipTo();
	}

}
