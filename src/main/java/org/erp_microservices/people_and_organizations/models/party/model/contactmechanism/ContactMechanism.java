package org.erp_microservices.people_and_organizations.models.party.model.contactmechanism;

import org.erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.facility.model.FacilityContactMechanism;
import org.erp_microservices.people_and_organizations.models.party.model.PartyContactMechanism;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:27 AM
 * @see Data Model Resource Book Volume 1 Figure 2.10, page 55
 * @see Data Model Resource Book Volume 1 Figure 2.11, page 59
 */
@Entity
public class ContactMechanism extends PersistentEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "specifiedVia", cascade = CascadeType.ALL)
	private List<FacilityContactMechanism> usedByFacilities = new ArrayList<FacilityContactMechanism>();

	@OneToMany(mappedBy = "specifiedVia", cascade = CascadeType.ALL)
	private List<PartyContactMechanism> usedByParties = new ArrayList<PartyContactMechanism>();


	/**
	 * @return the usedByFacilities
	 */
	public List<FacilityContactMechanism> getUsedByFacilities() {
		return usedByFacilities;
	}

	/**
	 * @param usedByFacilities the usedByFacilities to set
	 */

	public void setUsedByFacilities(
			List<FacilityContactMechanism> usedByFacilities) {
		this.usedByFacilities = usedByFacilities;
	}

	public List<PartyContactMechanism> getUsedByParties() {
		return usedByParties;
	}

	public void setUsedByParties(List<PartyContactMechanism> usedByParties) {
		this.usedByParties = usedByParties;
	}

}