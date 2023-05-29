package com.multi.liveAlone.share.bbsShare;

public class BbsShareVO {
	
	private int no;
	private String writer;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "BbsShareVO [no=" + no + ", writer=" + writer + "]";
	}
}
