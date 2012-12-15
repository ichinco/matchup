var Matchup = Matchup || {};
Matchup.Collection = Matchup.Collection || {};

Matchup.Collection.TeamList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Matchup.Model.Team;
    }
});