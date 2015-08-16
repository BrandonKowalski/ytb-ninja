package ninja.ytb.senpai.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import ninja.ytb.senpai.model.base.OrganizationalUnit;
import ninja.ytb.senpai.util.ConstantsUtility;

@NamedQueries({
    @NamedQuery(name = "Organizations.All", query = "SELECT o FROM Organization o")
})

@Entity
@DiscriminatorValue(ConstantsUtility.ORGANIZATION_DISCRIMINATOR)
public class Organization extends OrganizationalUnit {

	private static final long serialVersionUID = 3102447266964981637L;
	
	public Organization() {
	}

}
