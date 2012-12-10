modules = {
    app {
        dependsOn 'less'
    }
    less {
        dependsOn 'matchup'

        resource url: '/js/external/underscore-min.js'
    }
    matchup {
        dependsOn 'jquery, underscore, backbone'

    }
    backbone {
        resource url: '/js/external/backbone-min.js'
    }
    underscore {
        resource url: '/js/external/underscore-min.js'
    }
}