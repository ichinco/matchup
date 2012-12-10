var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Competition = Backbone.Model.extend({

    fetch: function() {
        var self = this;
        $.get(Competitions.Config.competitionBaseUrl + '/show?id=' + this.get(competitionId), function(response) {
            self.set(response);
            self.trigger('fetched');
        });
    },

    save: function() {

    }

});