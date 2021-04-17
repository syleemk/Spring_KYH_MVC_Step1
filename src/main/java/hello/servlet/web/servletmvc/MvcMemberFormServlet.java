package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSP와 Servlet을 사용한 MVC 패턴에서 Servlet이 Controller 역할
 */
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // controller에서 view로 이동할 때 사용하는 메서드 (dispatch : 보내다, 발송하다)
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // dispatcher를 통해서 서버 내부에서 viewPath 경로를 다시 호출 (포워딩)
        dispatcher.forward(request, response);
    }
}
