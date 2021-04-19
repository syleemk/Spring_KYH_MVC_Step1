package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 애노테이션 기반 컨트롤러는 ModelAndView를 반환해도되고 문자열을 반환해도된다.
    // 인터페이스로 되어있어서 딱 고정되어있지 않음. 굉장히 유연하게 설계됨
    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String newForm() {
        return "new-form";
    }

    // 애노테이션 기반 컨트롤러가 굉장히 유연한게 메서드 파라미터로 다양한 것을 받을 수 있음
    // HttpServletRequest, Response 직접 받을 수도 있고, 요청 파라미터를 직접 받을 수도 있음
    // Model도 받을 수 있음
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @RequestParam("username")String username,
            @RequestParam("age") int age,
            Model model
    ) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        // 모델에 데이터 담고 그냥 뷰 이름 반환해주면 끝남. 굉장히 깔끔함
        model.addAttribute("member", member);

        return "save-result";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members";
    }
}
