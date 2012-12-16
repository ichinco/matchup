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

        var competitionView = new Matchup.Views.CompetitionView({
            el : '#competition-list'
        });

        var competitionDialog = new Matchup.Views.AddCompetitionDialog({
            el : '#new-competition-dialog'
        });

        var newCompetitionButton = new Matchup.Views.AddCompetitionButton({
            el : '#new-competition',
            dialog : competitionDialog
        });
    }
});