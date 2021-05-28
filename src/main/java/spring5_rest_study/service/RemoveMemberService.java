package spring5_rest_study.service;

import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;

@Service
public interface RemoveMemberService {

	int removeMember(Member member);
}
