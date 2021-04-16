package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어있지 않음
 * 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //스프링 컨테이너를 사용하지 않기 때문에 직접 싱글톤으로 만들 것임
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    //싱글톤 만들경우 private으로 생성자 막아서 아무나 생성하지 못하도록 해야함
    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // 왜 새로 list 생성해서 전달해줌?
        // 반환한 리스트에 새로운 원소 삽입하거나 제거하는 등의 조작을 해도
        // 원본 store을 건드리지 않게하고 싶어서
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
    
}
