package org.erp_microservices.people_and_organizations.models.party.model.contactmechanism;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

/**
 * Responsible for maintaining information about the username, and protocol used
 * to contact someone via an instant message service.
 *
 * @author jim
 */
@SuppressWarnings("serial")
@Entity
public class InstantMessaging extends ContactMechanism {

	@NotEmpty
	private String protocol;

	@NotEmpty
	private String username;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
