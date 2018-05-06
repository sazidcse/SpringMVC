<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Story</title>
</head>
<body style="background-color: beige">
<a href="http://localhost:8080/">HOME</a></br></br></br>

<div>
    <form action="create_story" name="story" method="post">
        <input type="text" name="storyAuthor" placeholder="Your name"></br></br>
        <textarea type="text" name="storyTitle" placeholder="Story title"></textarea></br></br>
        <textarea type="text" name="storyDetails" placeholder="Story details"></textarea></br></br>
        <input type="submit" value="Create News">
    </form>
</div>

</body>
</html>
