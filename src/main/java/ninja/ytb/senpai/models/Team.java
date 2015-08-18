package ninja.ytb.senpai.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import ninja.ytb.senpai.model.base.OrganizationalUnit;
import ninja.ytb.senpai.util.ConstantsUtility;

@NamedQueries({
    @NamedQuery(name = "Teams.All", query = "SELECT t FROM Team t")
})

@Entity
@DiscriminatorValue(ConstantsUtility.TEAM_DISCRIMINATOR)
public class Team extends OrganizationalUnit {

	private static final long serialVersionUID = 7412914772548256588L;
	
	public Team() {
	}
}
