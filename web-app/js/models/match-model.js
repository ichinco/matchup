var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Match = Backbone.Model.extend({

    fetch: function() {
        var self = this;
        $.get(Competitions.Config.matchBaseUrl + '/show?id=' + this.get(matchId), function(response) {
            self.set(response);
            self.trigger('fetched');
        });
    }

});