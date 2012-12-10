var Competitions = Competitions || {};
Competitions.Router = Backbone.Router.extend({
    init: function() {
        this.main();
    },

    main: function() {

    	var bostonTaId = 60745;

        var backgroundView = new Destinations.BackgroundImageView({
            el: 'html'
        });

        var weatherModel = new Destinations.Models.Weather();
        var weatherView = new Destinations.Views.Weather({
            model: weatherModel,
            el: '.weather_display' // could be > 1
        });
        weatherModel.fetch();

        var awdDealsModel = new Destinations.Models.AwdDeals();
        var awdDealsView = new Destinations.Views.AwdDeals({
            model: awdDealsModel,
            el: '#home_airfarewatchdog'
        });

        var tingoDealsModel = new Destinations.Models.TingoDeals({
        	taid: bostonTaId
        });
        var tingoDealsView = new Destinations.Views.TingoDeals({
        	model: tingoDealsModel,
        	el: '#home_tingo'
        });

        var sniqueDealsModel = new Destinations.Models.SniqueDeals({
        	taid: bostonTaId
        });
        var sniqueDealsView = new Destinations.Views.SniqueDeals({
            model: sniqueDealsModel,
            el: '#home_snique'
        });

        //hotelDealsModel.fetch()

        var dropdownsByStm = new Destinations.Views.Dropdown({
            el: '.by_stm'
        });

        var dropdownsCities = new Destinations.Views.Dropdown({
            el: '.cities_thing'
        });

        var whyThisCityView = new Destinations.Views.WhyThisCity({
            el: '.why_this_city'
        });

        //var whatToDoView = new Destinations.Views.WhatToDo();
        var instructionsOverlay = new Destinations.Views.OverlayInstructions({
            el: '#overlay_instructions'
        });
        instructionsOverlay.show();
    }
});