package com.matchup

class Competition {

    int id;
    Date lastUpdated;
    Date dateCreated;
    String name;
    String description;
    Date enrollmentEndDate;

    static constraints = {
        enrollmentEndDate nullable:true
    }

    Set<Team> getTeams(){
        return CompetitionTeam.findAllByCompetition(this).collect { it.team } as Set
    }

    Set<Match> getMatches(){
        return CompetitionMatch.findAllByCompetition(this).collect { it.match } as Set
    }
}
