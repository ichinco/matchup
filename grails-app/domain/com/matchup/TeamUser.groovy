package com.matchup

import org.apache.commons.lang.builder.HashCodeBuilder

class TeamUser implements Serializable {

    Date lastUpdated;
    Date dateCreated;
    User user;
    Team team;

    static constraints = {
    }

	boolean equals(other) {
		if (!(other instanceof TeamUser)) {
			return false
		}

		other.user?.id == user?.id &&
			other.team?.id == team?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (team) builder.append(team.id)
		builder.toHashCode()
	}

	static TeamUser get(long userId, long teamId) {
		find 'from TeamUser where user.id=:userId and team.id=:teamId',
			[userId: userId, teamId: teamId]
	}

	static TeamUser create(User user, Team team, boolean flush = false) {
		new TeamUser(user: user, team: team).save(flush: flush, insert: true)
	}

	static boolean remove(User user, Team team, boolean flush = false) {
		TeamUser instance = TeamUser.findByUserAndTeam(user, team)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM TeamUser WHERE user=:user', [user: user]
	}

	static void removeAll(Team team) {
		executeUpdate 'DELETE FROM TeamUser WHERE team=:team', [team: team]
	}

	static mapping = {
		id composite: ['user', 'team']
		version false
	}
}
