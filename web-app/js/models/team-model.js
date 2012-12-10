var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Team = Backbone.Model.extend({

    fetch: function() {
        var self = this;
        $.get(Competitions.Config.teamBaseUrl + '/show?id=' + this.get(teamId), function(response) {
            self.set(response);
            self.trigger('fetched');
        });
    }

});