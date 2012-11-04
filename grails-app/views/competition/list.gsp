
<%@ page import="com.matchup.Competition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'competition.label', default: 'Competition')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'competition.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'competition.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'competition.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="enrollmentEndDate" title="${message(code: 'competition.enrollmentEndDate.label', default: 'Enrollment End Date')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'competition.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'competition.name.label', default: 'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${competitionInstanceList}" status="i" var="competitionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${competitionInstance.id}">${fieldValue(bean: competitionInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatDate date="${competitionInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: competitionInstance, field: "description")}</td>
                        
                            <td><g:formatDate date="${competitionInstance.enrollmentEndDate}" /></td>
                        
                            <td><g:formatDate date="${competitionInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: competitionInstance, field: "name")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${competitionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
