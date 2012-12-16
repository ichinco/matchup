var Competitions = Competitions || {};
Competitions.Router = Backbone.Router.extend({
    routes: {
        "home":                 "main",    // #help
        "search/:query":        "search",  // #search/kiwis
        "search/:query/p:page": "search"   // #search/kiwis/p7
    },

    init: function() {
        this.main();
    },

    main: function() {

        var competitionModel = new Matchup.Collection.CompetitionList({

        });

        var competitionView = new Matchup.Views.CompetitionView({
            el : '#competition-list',
            model : competitionModel
        });

        var competitionDialog = new Matchup.Views.AddCompetitionDialog({
            el : '#new-competition-dialog',
            model : competitionModel
        });

        var newCompetitionButton = new Matchup.Views.AddCompetitionButton({
            el : '#new-competition',
            model : competitionModel
        });
    }
});