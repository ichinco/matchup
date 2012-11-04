package com.matchup

class Team {

    int id;
    Date lastUpdated;
    Date dateCreated;
    String name;
    User captain;

    static constraints = {
    }

    Set<User> getUsers(){
        return TeamUser.findAllByTeam(this).collect { it.user } as Set
    }
}
