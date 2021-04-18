package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    // 이번 버전은 인터페이스에 ModelView가 없다.
    // model 객체는 파라미터로 전달되기 때문에 그냥 사용하면 된다.
    // 결과로 뷰의 이름만 반환하면 된다.
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
