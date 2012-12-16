modules = {
    less {
        dependsOn 'stylesheets'

        resource url: '/js/external/less-1.3.1.min.js', disposition: 'head'
    }
    stylesheets {
        resource url: '/less/matchup.less', attrs:[rel: "stylesheet/less", type:'css']
    }
    matchup {
        dependsOn 'jquery'
        dependsOn 'underscore'
        dependsOn 'backbone'
        dependsOn 'router'

        resource url: '/js/application.js'
    }
    router {
        dependsOn 'backbone'
        dependsOn 'views'

        resource url: '/js/router.js'
    }
    views {
        dependsOn 'models'
        dependsOn 'collections'
        dependsOn 'backbone'

        resource url : '/js/views/competition-view.js'
    }
    collections {
        dependsOn 'models'
        dependsOn 'backbone'

        resource url : "/js/collections/competition-list.js"
        resource url : '/js/collections/match-list.js'
        resource url : '/js/collections/team-list.js'
    }
    models {
        dependsOn 'config'
        dependsOn 'backbone'

        resource url : '/js/models/competition-model.js'
        resource url : '/js/models/match-model.js'
        resource url : '/js/models/team-model.js'
    }
    config {
        resource url : '/js/config/config.js'
    }
    backbone {
        dependsOn 'underscore'

        resource url: '/js/external/backbone-min.js'
    }
    underscore {
        resource url: '/js/external/underscore-min.js'
    }
}