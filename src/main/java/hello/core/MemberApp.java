package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();

        //앱컨피그에서 결정한걸 받음
        //MemberService memberService = appConfig.memberService();

        //appconfig에 있는 @bean을 컨테이너에 넣어 다 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //멤버서비스를 꺼냄
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "A", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member"+member.getName());
        System.out.println("find member"+findMember.getName());

    }
}
