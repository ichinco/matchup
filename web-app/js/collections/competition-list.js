var Matchup = Matchup || {};
Matchup.Collection = Matchup.Collection || {};

Matchup.Collection.CompetitionList = Backbone.Collection.extend({

    initialize : function() {
        this.model = Matchup.Models.Competition;
        this.url = "competition/list"
    }

});