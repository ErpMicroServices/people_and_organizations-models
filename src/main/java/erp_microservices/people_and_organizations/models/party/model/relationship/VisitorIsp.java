package erp_microservices.people_and_organizations.models.party.model.relationship;

import erp_microservices.people_and_organizations.models.party.model.PartyRole;

import javax.persistence.Entity;

@Entity
public class VisitorIsp extends PartyRelationship {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public PartyRole getRelationshipFrom() {
		return super.getRelationshipFrom();
	}

	public void setRelationshipFrom(PartyRole relationshipFrom) {
		super.setRelationshipFrom(relationshipFrom);
	}

	@Override
	public PartyRole getRelationshipTo() {
		return super.getRelationshipTo();
	}

	public void setRelationshipTo(PartyRole relationshipTo) {
		super.setRelationshipTo(relationshipTo);
	}


}
