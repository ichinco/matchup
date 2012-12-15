var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Competition = Backbone.Model.extend({

    initialize : function(){
        this.url = "competition";
    }

});