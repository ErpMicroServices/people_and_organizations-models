package org.erp_microservices.people_and_organizations.models.party.model.relationship;

import org.erp_microservices.fields.DateTimeRange;
import org.erp_microservices.model.PersistentEntity;
import org.erp_microservices.people_and_organizations.models.party.model.PartyRole;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * A relationship is defined by the two parties and their respective roles.
 *
 * @author Jim
 * @version 1.0
 * @created 25-Dec-2007 9:54:33 AM
 * @see Data Model Resource Book Volume 1 Figure 2.5, Page 41
 * @see Data Model Resource Book Volume 1 Figure 2.6a, Page 43
 * @see The Data Model Resource Book Volume 1 Figure 2.7, Page 48
 * @see Data Model Resource Book Volume 1 Figure 2.12, page 60
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PartyRelationship extends PersistentEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Lob
	private String comment;

	@ManyToOne
	private PriorityType priority;

	@ManyToOne(optional = false, targetEntity = PartyRole.class)
	@NotNull
	private PartyRole relationshipFrom;

	@ManyToOne(optional = false, targetEntity = PartyRole.class)
	@NotNull
	private PartyRole relationshipTo;

	@ManyToOne(targetEntity = StatusType.class)
	private StatusType status;

	@Embedded
	private DateTimeRange dateTimeRange = new DateTimeRange();

	public PartyRelationship() {
		super();
	}

	public PartyRelationship(PartyRole relationshipFrom, PartyRole relationshipTo) {
		super();
		this.relationshipFrom = relationshipFrom;
		this.relationshipTo = relationshipTo;
	}

	public PartyRelationship(String comment, PartyRole from, PartyRole to) {
		super();
		this.comment = comment;
		relationshipFrom = from;
		relationshipTo = to;
	}

	public PartyRelationship(UUID id, Long version, ZonedDateTime from, Optional<ZonedDateTime> thru, String comment,
	                         PartyRole relationshipFrom, PartyRole relationshipTo) {
		super(id, version);
		this.dateTimeRange.setFromDate(from);
		// TODO When hibernate fixes itself so that it can handle converters,
		// get rid of the orElse.
		this.dateTimeRange.setThruDate(thru.orElse(null));
		this.comment = comment;
		this.relationshipFrom = relationshipFrom;
		this.relationshipTo = relationshipTo;
	}

	public PartyRelationship(ZonedDateTime from, Optional<ZonedDateTime> thru, String comment,
	                         PartyRole relationshipFrom, PartyRole relationshipTo) {
		this.dateTimeRange.setFromDate(from);
		// TODO When hibernate fixes itself so that it can handle converters,
		// get rid of the orElse.
		this.dateTimeRange.setThruDate(thru.orElse(null));
		this.comment = comment;
		this.relationshipFrom = relationshipFrom;
		this.relationshipTo = relationshipTo;
	}

	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}

	@Transient
	@AssertFalse
	public boolean isRelationshipRolesNull() {
		return relationshipFrom == null || relationshipTo == null;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}

	protected PartyRole getRelationshipFrom() {
		return relationshipFrom;
	}

	protected void setRelationshipFrom(PartyRole relationshipFrom) {
		this.relationshipFrom = relationshipFrom;
	}

	protected PartyRole getRelationshipTo() {
		return relationshipTo;
	}

	protected void setRelationshipTo(PartyRole relationshipTo) {
		this.relationshipTo = relationshipTo;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format(
				"PartyRelationship [comment=%s, priority=%s, relationshipFrom=%s, relationshipTo=%s, status=%s, dateTimeRange=%s, getId()=%s, getVersion()=%s]",
				comment, priority, relationshipFrom, relationshipTo, status, dateTimeRange, getId(), getVersion());
	}

}