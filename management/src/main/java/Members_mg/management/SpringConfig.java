package Members_mg.management;

import Members_mg.management.domain.Member;
import Members_mg.management.repository.MemberRepository;
import Members_mg.management.repository.*;
import Members_mg.management.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


   @Bean
    public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        //    return new JdbcMemberRepository(dataSource);
        //    return new JdbcTemplateMemberRepository(dataSource);
        //    return new JpaMemberRepository(em);

    }
}


