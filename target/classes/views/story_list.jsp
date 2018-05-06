<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Story List</title>
</head>
<body style="background-color: beige">
<a href="http://localhost:8080/">HOME</a></br></br></br>

<div>
    <c:forEach var="story" items="${storyList}">
            <ul><i><a href="http://localhost:8080/view_story/${story.getStoryId()}">${story.getStoryTitle()}</a></i></ul>
    </c:forEach>
</div>
${story}
</body>
</html>
