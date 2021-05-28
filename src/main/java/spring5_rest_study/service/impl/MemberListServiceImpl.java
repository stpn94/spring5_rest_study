package spring5_rest_study.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapper;
import spring5_rest_study.service.MemberListService;

@Service
public class MemberListServiceImpl implements MemberListService {
	
	private static final Log log = LogFactory.getLog(MemberListServiceImpl.class);
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> getLists() {
		List<Member> list = memberMapper.selectMemberByAll();
		log.debug("service - getList() > " + list.size());
		return list;
	}

}
