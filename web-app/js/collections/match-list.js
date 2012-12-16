var Matchup = Matchup || {};
Matchup.Collection = Matchup.Collection || {};

Matchup.Collection.MatchList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Matchup.Models.Match;
        this.url = "match/list"
    }
});