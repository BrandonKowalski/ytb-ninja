package ninja.ytb.senpai.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import ninja.ytb.senpai.model.base.OrganizationalUnit;
import ninja.ytb.senpai.util.ConstantsUtility;

@NamedQueries({
    @NamedQuery(name = "Projects.All", query = "SELECT p FROM Project p")
})

@Entity
@DiscriminatorValue(ConstantsUtility.PROJECT_DISCRIMINATOR)
public class Project extends OrganizationalUnit {

	private static final long serialVersionUID = -3488046703025375071L;
	
	public Project() {
	}
}
