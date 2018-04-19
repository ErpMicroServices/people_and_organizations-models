package org.erp_microservices.people_and_organizations.models.facility.model;

import erp_microservices.model.PersistentEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:29 AM
 * @see Data Model Resource Book Volume 1 Figure 2.11, page 59
 * @see Data Model Resource Book Volume 1 Figure 3.5, page 82
 */
@Entity
public class Facility extends PersistentEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<FacilityContactMechanism> contactedVia = new ArrayList<FacilityContactMechanism>();

	@NotEmpty
	@Lob
	private String description;

	@OneToMany
	private List<FacilityRole> involving = new ArrayList<FacilityRole>();

	@OneToMany
	private List<Facility> madeUpOf = new ArrayList<Facility>();

	@ManyToOne
	private Facility partOf;

	/**
	 * @return the contactedVia
	 */

	public List<FacilityContactMechanism> getContactedVia() {
		return contactedVia;
	}

	/**
	 * @param contactedVia the contactedVia to set
	 */
	public void setContactedVia(List<FacilityContactMechanism> contactedVia) {
		this.contactedVia = contactedVia;
	}

	/**
	 * @return the description
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the involving
	 */

	public List<FacilityRole> getInvolving() {
		return involving;
	}

	/**
	 * @param involving the involving to set
	 */
	public void setInvolving(List<FacilityRole> involving) {
		this.involving = involving;
	}

	/**
	 * @return the madeUpOf
	 */

	public List<Facility> getMadeUpOf() {
		return madeUpOf;
	}

	/**
	 * @param madeUpOf the madeUpOf to set
	 */
	public void setMadeUpOf(List<Facility> madeUpOf) {
		this.madeUpOf = madeUpOf;
	}

	/**
	 * @return the partOf
	 */

	public Facility getPartOf() {
		return partOf;
	}

	/**
	 * @param partOf the partOf to set
	 */
	public void setPartOf(Facility partOf) {
		this.partOf = partOf;
	}

}