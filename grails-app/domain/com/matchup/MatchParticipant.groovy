package com.matchup

import org.apache.commons.lang.builder.HashCodeBuilder

class MatchParticipant implements Serializable {

    Date dateCreated
    Date lastUpdated
    Match match
    Team team
    double score
    double rank

    static constraints = {
    }

	boolean equals(other) {
		if (!(other instanceof MatchParticipant)) {
			return false
		}

		other.team?.id == team?.id &&
			other.match?.id == match?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (match) builder.append(match.id)
		if (team) builder.append(team.id)
		builder.toHashCode()
	}

	static MatchParticipant get(long teamId, long matchId) {
		find 'from CompetitionTeam where match.id=:matchId and team.id=:teamId',
			[teamId: teamId, matchId: matchId]
	}

	static MatchParticipant create(Match match, Team team, boolean flush = false) {
		new MatchParticipant(match: match, team: team).save(flush: flush, insert: true)
	}

	static boolean remove(Match match, Team team, boolean flush = false) {
		MatchParticipant instance = MatchParticipant.findByMatchAndTeam(match, team)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Match match) {
		executeUpdate 'DELETE FROM MatchParticipant WHERE match=:match', [match: match]
	}

	static void removeAll(Team team) {
		executeUpdate 'DELETE FROM MatchParticipant WHERE team=:team', [team: team]
	}

	static mapping = {
		id composite: ['match', 'team']
		version false
	}
}
