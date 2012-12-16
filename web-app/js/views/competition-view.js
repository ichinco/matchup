var Matchup = Matchup || {};
Matchup.Views = Matchup.Views || {};

Matchup.Views.CompetitionView = Backbone.View.extend({

    template: _.template($("#competition_template").html()),
    render: function() {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    },

    initialize: function() {
        _.bindAll(this);
//        this.model.bind('fetched', this.render);
    }

});

Matchup.Views.AddCompetitionButton = Backbone.View.extend({
    dialog : null,

    events: {
        'click': 'onClick'
    },

    onClick: function() {
        this.dialog.show();
    }
});

Matchup.Views.AddCompetitionDialog = Backbone.View.extend({

    show: function() {
        this.$el.fadeIn();
    }
});