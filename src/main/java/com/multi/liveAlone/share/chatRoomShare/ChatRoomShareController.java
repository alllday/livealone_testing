package com.multi.liveAlone.share.chatRoomShare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.liveAlone.share.messageShare.MessageShareVO;

@Controller
public class ChatRoomShareController {

	@Autowired
	ChatRoomShareDAO dao;
	
	// 채팅방 insert 동시에 채팅방 페이지(채팅이 이루어지는 공간)로 이동 + roomInfo(roomId, chatRequestor) 데이터 보내기
	@RequestMapping("chatRoom")
	public void insert(ChatRoomShareVO bag, Model model) {
		
		ChatRoomShareVO roomInfo;
		List<MessageShareVO> list;
		
		// 게시글 작성자가 아닌 회원이 채팅요청을 했을 때
		if (bag.getRoomId() == 0) {
			// 만들어진 채팅방의 roomId, chatRequestor 가져와서 views의 chatRoom.jsp에 전달
			roomInfo = dao.one(bag);
//			System.out.println(roomInfo);
			
			// db에 채팅방이 없으면 채팅방생성s
			if (roomInfo == null) {
				System.out.println(bag);
				dao.insert(bag); // 채팅방 생성 -> db삽입
				
				roomInfo = dao.one(bag);
//				System.out.println(roomInfo2.getRoomId());
//				System.out.println(roomInfo2.getChatRequestor());
				model.addAttribute("roomInfo", roomInfo);
			}
			
			// db에 채팅방이 이미 있으면 채팅방생성x
			else {
				model.addAttribute("roomInfo", roomInfo);
			}
		}
		// 게시글 작성자가 게시글채팅목록에서 채팅방에 들어갈 때
		else {
			roomInfo = dao.one_roomId(bag);
			model.addAttribute("roomInfo", roomInfo);
		}
		
		list = dao.messageList(roomInfo.getRoomId());
		model.addAttribute("list", list);
	}
	
	// 모든 채팅방 목록
//	@RequestMapping("allChatList")
//	public void list(Model model) {
//		List<ChatRoomShareVO> list = dao.list();
//		
//		model.addAttribute("list", list);
//	}
	
	// 게시물 채팅방 목록
	@RequestMapping("bbsChatList")
	public void bbschatlist(int bbsNo, Model model) {
		List<ChatRoomShareVO> list = dao.bbschatlist(bbsNo);
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping("codeCheck")
	@ResponseBody
	public int codeCheck(String requestor, String receiver, String nowSession, ChatRoomShareVO bag) {
		ChatRoomShareVO bag2 = dao.one_roomId(bag);
		System.out.println(bag2);
		int chatcode = bag2.getChatCode();
		System.out.println(chatcode);
		System.out.println(requestor);
		System.out.println(receiver);
		System.out.println(nowSession);
		
		if (chatcode == 0 && nowSession.equals(requestor)) {
			bag2.setChatCode(1);
			System.out.println("1111");
		}
		else if (chatcode == 0 && nowSession.equals(receiver)) {
			bag2.setChatCode(2);
			System.out.println("2222");
		}
		else if ((chatcode == 1 && nowSession.equals(receiver)) || (chatcode == 2 && nowSession.equals(requestor))) {
			bag2.setChatCode(3);
			System.out.println("3333");
		}
		
		dao.codeUpdate(bag2);
		chatcode = bag2.getChatCode();
		
		System.out.println("--------check---------");
		System.out.println(bag2);
		System.out.println("chatcode : " + chatcode);
		return chatcode;
	}
}
