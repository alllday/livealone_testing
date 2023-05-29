package com.multi.liveAlone.share.bbsShare;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.liveAlone.MemberVO;

@Component
public class BbsShareDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public List<BbsShareVO> list() {
		List<BbsShareVO> list = my.selectList("bbs_test.all");
		System.out.println("게시물 개수 : " + list.size());
		return list;
	}
	
	public BbsShareVO one(int no) {
		BbsShareVO bag = my.selectOne("bbs_test.one", no);
		return bag;
	}
}
