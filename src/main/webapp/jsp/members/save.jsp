<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        // request, response 그냥 사용 가능
        // jsp 파일도 서블릿으로 변환되어서 사용되기 때문에, 서비스 로직이 그대로 호출된다 생각하면됨
        MemberRepository memberRepository = MemberRepository.getInstance();
        System.out.println("save.jsp");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);
%>
<html>
<head>
        <meta charset="UTF-8">
</head>
<body>
성공
<ul>
        <li>id=<%=member.getId()%></li>
        <li>username=<%=member.getUsername()%></li>
        <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>