var Matchup = Matchup || {};
Matchup.Collection = Matchup.Collection || {};

Matchup.Collection.CompetitionList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Matchup.Model.Competition;
        this.url = "/competition/list"
    }
});