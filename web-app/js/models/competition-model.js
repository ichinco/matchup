var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Competition = Backbone.Model.extend({

    initialize : function(){
        _.bindAll(this);
        this.url = "competition";
    }

});