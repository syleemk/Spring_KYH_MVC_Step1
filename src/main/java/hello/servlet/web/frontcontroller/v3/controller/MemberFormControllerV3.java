package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // viewPath 전체를 넣는 것이 아니라 view의 논리적인 이름을 넣어서 반환
        return new ModelView("new-form");
    }
}
