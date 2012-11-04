package com.matchup

class Match {

    int id
    Date lastUpdated;
    Date dateCreated;

    static constraints = {
    }

    Set<MatchParticipant> getTeams(){
        return MatchParticipant.findAllByMatch(this) as Set
    }
}
