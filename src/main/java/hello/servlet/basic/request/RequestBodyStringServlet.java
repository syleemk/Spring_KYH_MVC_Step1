package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 이렇게 하면 메시지 바디의 내용을 바이트 코드로 바로 얻을 수 있음
        ServletInputStream inputStream = request.getInputStream();
        // 바이트 코드를 문자열로 바꿔야하는데, 여기서는 Spring이 제공하는 util 메서드를 사용
        // 바이트를 문자로 변환할 때는 인코딩 방식을 알려줘야함, 반대로 문자를 바이트로 바꿀 때도 인코딩 방식 알려줘야함
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");

    }
}
