package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        //ControllerV3를 구현한 객체만 true를 리턴
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // supports로 이미 한번 걸렀기 때문에 타입 캐스팅해도 된다.
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);
        // 이제 frontController대신 handlerAdapter에서 controller 호출해준다.
        ModelView mv = controller.process(paramMap);

        // 컨트롤러의 반환 결과를 ModelView로 맞추어서 반환해준다
        // V3의 경우는 ModelView로 반환해주기때문에 맞지만, V4의 경우는 String으로 반환하는데
        // 이를 ModelView로 변환해서 반환해줘야한다.
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        // paramMap
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
