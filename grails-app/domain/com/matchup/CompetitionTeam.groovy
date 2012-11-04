package com.matchup

import org.apache.commons.lang.builder.HashCodeBuilder

class CompetitionTeam implements Serializable {

    Date lastUpdated;
    Date dateCreated;
    Competition competition;
    Team team;
    double rank;

    static constraints = {
    }

	boolean equals(other) {
		if (!(other instanceof CompetitionTeam)) {
			return false
		}

		other.team?.id == team?.id &&
			other.competition?.id == competition?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (competition) builder.append(competition.id)
		if (team) builder.append(team.id)
		builder.toHashCode()
	}

	static CompetitionTeam get(long teamId, long competitionId) {
		find 'from CompetitionTeam where competition.id=:competitionId and team.id=:teamId',
			[teamId: teamId, competitionId: competitionId]
	}

	static CompetitionTeam create(Competition competition, Team team, boolean flush = false) {
		new CompetitionTeam(competition: competition, team: team).save(flush: flush, insert: true)
	}

	static boolean remove(Competition competition, Team team, boolean flush = false) {
		CompetitionTeam instance = CompetitionTeam.findByCompetitionAndTeam(competition, team)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Competition competition) {
		executeUpdate 'DELETE FROM CompetitionTeam WHERE competition=:competition', [competition: competition]
	}

	static void removeAll(Team team) {
		executeUpdate 'DELETE FROM CompetitionTeam WHERE team=:team', [team: team]
	}

	static mapping = {
		id composite: ['competition', 'team']
		version false
	}
}
