var Matchup = Matchup || {};
Matchup.Views = Matchup.Views || {};

Matchup.Views.CompetitionView = Backbone.View.extend({

    template: _.template($("#competition_template").html()),

    render: function() {
        var template = _.template(this.template());
        var finalHtml = "";
        _.each(this.model.models, function (e){
            finalHtml += (template(e));
        });
        this.$el.html(finalHtml);
        return this;
    },

    initialize: function() {
        _.bindAll(this);
        this.model.bind('all', this.render);
    }

});

Matchup.Views.AddCompetitionDialog = Backbone.View.extend({

    events: {
        'click .create-competition': 'close'
    },

    initialize : function() {
        _.bindAll(this);
        this.model.bind('new-competition-dialog-open', this.show);
    },

    show: function() {
        this.$el.show();
    },

    close : function (){
        console.log(this.model);
        this.model.create({
            name : this.$el.children('.name').first().val(),
            description : this.$el.children('.description').first().val()
        });
        this.$el.hide();
    }
});

Matchup.Views.AddCompetitionButton = Backbone.View.extend({
    events: {
        'click': 'onClick'
    },

    onClick: function() {
        this.model.trigger("new-competition-dialog-open");
    }
});