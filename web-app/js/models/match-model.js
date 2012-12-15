var Matchup = Matchup || {};
Matchup.Models = Matchup.Models || {};

Matchup.Models.Match = Backbone.Model.extend({

    initialize : function (){
        this.url = "match";
    }

});