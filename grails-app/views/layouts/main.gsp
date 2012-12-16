<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <r:layoutResources />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="grailsLogo"><a href="http://grails.org"><img src="${resource(dir:'images',file:'grails_logo.png')}" alt="Grails" border="0" /></a></div>

        <script type="text/template" id="competition_template">
            <div>
                <div><%=name%></div>
                <div><%=description%></div>
            </div>
        </script>

        <script type="text/template" id="team_template">
            <div>
                <div><%=name%></div>
            </div>
        </script>

        <script type="text/template" id="match_template">
            <div>
                <div><%=name%></div>
            </div>
        </script>


        <g:layoutBody />
        <r:layoutResources />
    </body>
</html>