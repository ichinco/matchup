var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Team = Backbone.Model.extend({

    initialize : function(){
        this.url = "team";
    }

});