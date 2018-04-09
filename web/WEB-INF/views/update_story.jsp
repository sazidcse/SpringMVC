<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateStory</title>
</head>
<body style="background-color: beige">
<a href="http://localhost:8080/">HOME</a></br></br></br>

<div>
    <form action="update_story" name="story" method="post">
        <textarea type="text" name="storyId" style="display:none">${story.storyId}</textarea>
        <textarea type="text" name="storyAuthor" >${story.storyAuthor}</textarea></br></br>
        <textarea type="text" name="storyTitle" >${story.storyTitle}</textarea></br></br>
        <textarea type="text" name="storyDetails" >${story.storyDetails}</textarea></br></br>
        <input type="submit" value="Update Story">
    </form>
</div>

</body>
</html>
