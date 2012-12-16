var Matchup = Matchup || {};
Matchup.Collection = Matchup.Collection || {};

Matchup.Collection.TeamList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Matchup.Models.Team;
        this.url = "team/list"
    }
});