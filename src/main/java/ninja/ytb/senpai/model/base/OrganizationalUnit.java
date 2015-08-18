package ninja.ytb.senpai.model.base;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ninja.ytb.senpai.models.Organization;
import ninja.ytb.senpai.models.Project;
import ninja.ytb.senpai.models.Team;
import ninja.ytb.senpai.util.ConstantsUtility;

@NamedQueries({
    @NamedQuery(name = "OrganizationalUnit.All", query = "SELECT o FROM OrganizationalUnit o"),
    @NamedQuery(name = "OrganizationalUnit.ById", query = "SELECT o FROM OrganizationalUnit o WHERE o.id = id")
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class OrganizationalUnit extends GenericEntity {

	private static final long serialVersionUID = 1739235425096006988L;

	private String name;

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
	@JsonSubTypes({ @Type(value = Organization.class, name = ConstantsUtility.ORGANIZATION_DISCRIMINATOR),
			@Type(value = Team.class, name = ConstantsUtility.TEAM_DISCRIMINATOR),
			@Type(value = Project.class, name = ConstantsUtility.PROJECT_DISCRIMINATOR) })
	@ManyToOne
	private OrganizationalUnit superior;

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
	@JsonSubTypes({ @Type(value = Organization.class, name = ConstantsUtility.ORGANIZATION_DISCRIMINATOR),
			@Type(value = Team.class, name = ConstantsUtility.TEAM_DISCRIMINATOR),
			@Type(value = Project.class, name = ConstantsUtility.PROJECT_DISCRIMINATOR) })
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<OrganizationalUnit> subordinates;

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final OrganizationalUnit getSuperior() {
		return superior;
	}

	public final void setSuperior(final OrganizationalUnit superior) {
		this.superior = superior;
	}

	public final Collection<OrganizationalUnit> getSubordinates() {
		return subordinates;
	}

	public final void setSubordinates(final Collection<OrganizationalUnit> subordinates) {
		this.subordinates = subordinates;
	}
}
