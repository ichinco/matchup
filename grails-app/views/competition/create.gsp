

<%@ page import="com.matchup.Competition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'competition.label', default: 'Competition')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${competitionInstance}">
            <div class="errors">
                <g:renderErrors bean="${competitionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="competition.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: competitionInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${competitionInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enrollmentEndDate"><g:message code="competition.enrollmentEndDate.label" default="Enrollment End Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: competitionInstance, field: 'enrollmentEndDate', 'errors')}">
                                    <g:datePicker name="enrollmentEndDate" precision="day" value="${competitionInstance?.enrollmentEndDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="competition.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: competitionInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${competitionInstance?.name}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
