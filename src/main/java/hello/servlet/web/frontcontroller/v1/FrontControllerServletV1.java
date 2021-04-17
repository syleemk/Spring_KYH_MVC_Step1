package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    //url mapping 정보, 어떤 url이 호출되면 어떤 컨트롤러를 호출해야하는 지에 대한 정보
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //이 서블릿이 생성될 때, 매핑정보 그냥 넣어줌
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        //호출된 URI 가져오기
        String requestURI = request.getRequestURI();
        //매핑 정보로부터 해당 URI를 처리하는 컨트롤러 꺼내온다
        //인터페이스를 사용했기 때문에 코드를 일관성있게 사용 가능 (다형성)
        ControllerV1 controller = controllerMap.get(requestURI);
        //예외 처리
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //다형성으로 인해 오버라이딩 된 메서드가 호출된다.
        controller.process(request, response);
    }
}
