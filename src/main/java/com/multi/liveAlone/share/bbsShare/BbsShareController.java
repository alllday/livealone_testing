package com.multi.liveAlone.share.bbsShare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsShareController {

	@Autowired
	BbsShareDAO dao;
	
	@RequestMapping("list")
	public void list(Model model) {
		List<BbsShareVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("one")
	public void one(int no, Model model) {
		BbsShareVO bag = dao.one(no);
		model.addAttribute("bag", bag);
	}
}
