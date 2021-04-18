package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component 애노테이션으로 스프링 빈 등록 가능
//속성값으로 스프링 빈의 이름 지정해줄 수 있다
//여기선 스프링 빈의 이름을 url 패턴에 맞춘 것 -> 이렇게 하면 해당 url로 이 컨트롤러 호출 가능
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
