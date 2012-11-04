package com.matchup

import com.matchup.competitions.CompetitionType

class Competition {

    int id;
    Date lastUpdated;
    Date dateCreated;
    String name;
    String description;
    Date enrollmentEndDate;

    static constraints = {
    }

    Set<Team> getTeams(){
        return CompetitionTeam.findAllByCompetition(this).collect { it.team } as Set
    }

    Set<Match> getMatches(){
        return CompetitionMatch.findAllByCompetition(this).collect { it.match } as Set
    }
}
