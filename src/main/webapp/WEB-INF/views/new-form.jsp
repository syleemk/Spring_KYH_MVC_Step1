<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
    <%-- 절대경로라면 [host 주소뒤에 + /절대경로], 보통은 절대경로 해주는 게 더 좋을거라 함 --%>
    <form action="save" method="post">
        username: <input type="text" name="username" />
        age: <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>