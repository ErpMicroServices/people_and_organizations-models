package erp_microservices.people_and_organizations.models.party.model.communication;

import erp_microservices.model.PersistentEntity;
import erp_microservices.people_and_organizations.models.party.model.Party;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:27 AM
 * @see "Data Model Resource Book Volume 1 Figure 2.12, page 60"
 */
@SuppressWarnings("serial")
@Entity
public class CommunicationEventRole extends PersistentEntity {

	@ManyToOne
	private CommunicationEventRoleType describedBy;

	@ManyToOne
	private Party forParty;

	@ManyToOne
	@JoinColumn(name = "communicationEventOf")
	private CommunicationEvent of;

	@NotNull
	@ManyToOne
	private CommunicationEventRoleType type;


	/**
	 * @return the describedBy
	 */

	public CommunicationEventRoleType getDescribedBy() {
		return describedBy;
	}

	/**
	 * @param describedBy the describedBy to set
	 */
	public void setDescribedBy(CommunicationEventRoleType describedBy) {
		this.describedBy = describedBy;
	}

	/**
	 * @return the forParty
	 */

	public Party getForParty() {
		return forParty;
	}

	/**
	 * @param forParty the forParty to set
	 */
	public void setForParty(Party forParty) {
		this.forParty = forParty;
	}

	/**
	 * @return the of
	 */

	public CommunicationEvent getOf() {
		return of;
	}

	/**
	 * @param of the of to set
	 */
	public void setOf(CommunicationEvent of) {
		this.of = of;
	}

	public CommunicationEventRoleType getType() {
		return type;
	}

	public void setType(CommunicationEventRoleType type) {
		this.type = type;
	}

}