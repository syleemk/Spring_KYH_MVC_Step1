package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // 인자로 전달된 핸들러를 어댑터가 처리할 수 있는지 판단하는 메서드
    boolean supports(Object handler);

    // 인자로 전달된 핸들러를 호출해주는 메서드이다.
    // ModelView를 반환한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
