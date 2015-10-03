package ninja.ytb.senpai.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

import ninja.ytb.senpai.models.Blocker;
import ninja.ytb.senpai.models.Status;
import ninja.ytb.senpai.models.Today;
import ninja.ytb.senpai.models.Yesterday;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class StatusPart extends GenericEntity {

	private static final long serialVersionUID = -5226506692662730792L;
	
	private String message;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Status status;

	@Any(metaColumn = @Column(name = "vehicleType") )
	@AnyMetaDef(idType = "uuid", metaType = "string", metaValues = {
			@MetaValue(targetEntity = Yesterday.class, value = "yesterday"),
			@MetaValue(targetEntity = Today.class, value = "today"),
			@MetaValue(targetEntity = Blocker.class, value = "blocker")})
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@OneToOne
	@JoinColumn(name = "previousPart")
	private StatusPart previousPart;

	public StatusPart() {
		
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(final String message) {
		this.message = message;
	}

	public final Status getStatus() {
		return status;
	}

	public final void setStatus(final Status status) {
		this.status = status;
	}

	public final StatusPart getPreviousPart() {
		return previousPart;
	}

	public final void setPreviousPart(final StatusPart previousPart) {
		this.previousPart = previousPart;
	}
}
