<%--
  Created by IntelliJ IDEA.
  User: denise
  Date: 12/15/12
  Time: 3:12 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <r:require module="less" />
    <r:require module="matchup" />
    <meta name="layout" content="main" />
  </head>
  <body>

  <div id="competition-list">

  </div>

  <button id="new-competition">create new competition</button>
  <div id="new-competition-dialog" class="stealth">
      <label for="name">name</label>
      <g:textField class="name" name="name" />
      <label for="description">description</label>
      <g:textArea class="description" name="description" rows="3" cols="100"/>

      <button class='create-competition'>create competition</button>
  </div>
  </body>
</html>