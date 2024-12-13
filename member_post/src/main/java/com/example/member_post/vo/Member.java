package com.example.member_post.vo;

import java.util.*;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String roadAddr;
	private String detailAddr;
	private Date createDate;

	public Member() {}

	private Member(String id, String pw, String name, String email, String roadAddr, String detailAddr,
			Date createDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.roadAddr = roadAddr;
		this.detailAddr = detailAddr;
		this.createDate = createDate;
		
	}

	public static M builder() {
		return new M();
	}

	public int getNum() {
		return 20;
	}
	
//	인스턴스 클래스 라서 static class를 해야 빌더 패턴을 사용할 수 있다
	public static class M {
		String id;
		String pw;
		String name;
		String email;
		String roadAddr;
		String detailAddr;
		Date createDate;

		public M id(String id) {
			this.id = id;
			return this;
		}

		public M pw(String pw) {
			this.pw = pw;
			return this;
		}

		public M name(String name) {
			this.name = name;
			return this;
		}

		public M email(String email) {
			this.email = email;
			return this;
		}

		public M roadAddr(String roadAddr) {
			this.roadAddr = roadAddr;
			return this;
		}

		public M detailAddr(String detailAddr) {
			this.detailAddr = detailAddr;
			return this;
		}

		public M createDate(Date string) {
			this.createDate = string;
			return this;
		}

		public Member build() {
			return new Member(id,pw,name,email,roadAddr, detailAddr, createDate);
		}
	}

}
