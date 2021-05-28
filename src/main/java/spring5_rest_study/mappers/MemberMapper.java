package spring5_rest_study.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import spring5_rest_study.dto.Member;

@Component
public interface MemberMapper {

	List<Member> selectMemberByAll();

	Member selectMemberById(long memId);

	int insertMember(Member member);

	int updateMember(Member member);

	int deleteMember(Member member);

}