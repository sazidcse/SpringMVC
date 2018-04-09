<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Story View</title>
</head>
<body style="background-color: beige">
<a href="http://localhost:8080/">HOME</a></br></br></br>

<div style="width: 100%">
    <i><b>Title: </b>${story.storyTitle}</i>
</div></br></br>

<div style="width: 100%">
    <i><b>Body: </b>${story.storyDetails}</i>
</div></br></br>

<div style="width: 100%">
    <i><b>Author: </b>${story.storyAuthor}</i>
</div>

</br></br></br>

<div>
    <a href="http://localhost:8080/update_request/${story.storyId}">UPDATE</a>&nbsp;&nbsp;
    <a href="http://localhost:8080/delete_request/${story.storyId}">DELETE</a>
</div>

</body>

</html>
