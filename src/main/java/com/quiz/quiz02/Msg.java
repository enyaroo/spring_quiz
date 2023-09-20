package com.quiz.quiz02;

public class Msg {
	private String title;
	private String user;
	private String content;
	
	// 생성자
	// 기본 생성자 - 이거 만들어놔야 파라미터 필수생성자가 있어도 그냥 기본생성자로 setter이용해서 생성가능
	public Msg() {
	}
	// 파라미터 필수 생성자
	public Msg(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
