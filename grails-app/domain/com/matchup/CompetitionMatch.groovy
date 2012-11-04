package com.matchup

import org.apache.commons.lang.builder.HashCodeBuilder

class CompetitionMatch implements Serializable {

    Date lastUpdated
    Date dateCreated
    Competition competition
    Match match

    static constraints = {
    }

	boolean equals(other) {
		if (!(other instanceof CompetitionMatch)) {
			return false
		}

		other.competition?.id == competition?.id &&
			other.match?.id == match?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (match) builder.append(match.id)
		if (competition) builder.append(competition.id)
		builder.toHashCode()
	}

	static CompetitionMatch get(long competitionId, long matchId) {
		find 'from CompetitionTeam where match.id=:matchId and competition.id=:competitionId',
			[competitionId: competitionId, matchId: matchId]
	}

	static CompetitionMatch create(Match match, Competition competition, boolean flush = false) {
		new CompetitionMatch(match: match, competition: competition).save(flush: flush, insert: true)
	}

	static boolean remove(Match match, Competition competition, boolean flush = false) {
		CompetitionMatch instance = CompetitionMatch.findByMatchAndCompetition(match, competition)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(Match match) {
		executeUpdate 'DELETE FROM CompetitionMatch WHERE match=:match', [match: match]
	}

	static void removeAll(Competition competition) {
		executeUpdate 'DELETE FROM CompetitionMatch WHERE competition=:competition', [competition: competition]
	}

	static mapping = {
		id composite: ['match', 'competition']
		version false
	}
}
