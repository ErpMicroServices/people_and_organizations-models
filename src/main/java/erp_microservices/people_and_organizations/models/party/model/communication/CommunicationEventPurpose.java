package erp_microservices.people_and_organizations.models.party.model.communication;

import erp_microservices.fields.DateTimeRange;
import erp_microservices.model.PersistentEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CommunicationEventPurpose extends PersistentEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	private CommunicationEventPurposeType type;

	@Embedded
	private DateTimeRange dateTimeRange = new DateTimeRange();


	public DateTimeRange getDateTimeRange() {
		return dateTimeRange;
	}

	public void setDateTimeRange(DateTimeRange dateTimeRange) {
		this.dateTimeRange = dateTimeRange;
	}


	public CommunicationEventPurposeType getType() {
		return type;
	}

	public void setType(CommunicationEventPurposeType type) {
		this.type = type;
	}
}
