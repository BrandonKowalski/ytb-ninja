package ninja.ytb.senpai.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ninja.ytb.senpai.model.base.OrganizationalUnit;
import ninja.ytb.senpai.util.ConstantsUtility;

@Entity
@DiscriminatorValue(ConstantsUtility.TEAM_DISCRIMINATOR)
public class Team extends OrganizationalUnit {

	private static final long serialVersionUID = 7412914772548256588L;
	
	public Team() {
	}
}
