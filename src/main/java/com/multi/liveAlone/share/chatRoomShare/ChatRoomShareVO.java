package com.multi.liveAlone.share.chatRoomShare;

public class ChatRoomShareVO {
	private int roomId;
	private int bbsNo;
	private String chatRequestor;
	private String chatReceiver;
	private int chatCode;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getChatRequestor() {
		return chatRequestor;
	}
	public void setChatRequestor(String chatRequestor) {
		this.chatRequestor = chatRequestor;
	}
	public String getChatReceiver() {
		return chatReceiver;
	}
	public void setChatReceiver(String chatReceiver) {
		this.chatReceiver = chatReceiver;
	}
	public int getChatCode() {
		return chatCode;
	}
	public void setChatCode(int chatCode) {
		this.chatCode = chatCode;
	}
	@Override
	public String toString() {
		return "ChatRoomShareVO [roomId=" + roomId + ", bbsNo=" + bbsNo + ", chatRequestor=" + chatRequestor
				+ ", chatReceiver=" + chatReceiver + ", chatCode=" + chatCode + "]";
	}
}
