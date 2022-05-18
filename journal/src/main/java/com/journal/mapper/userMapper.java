package com.journal.mapper;

import com.journal.model.userVO;

public interface userMapper {
	
	/* 회원가입 */
	public void register(userVO user);
	
	/* 아이디 중복 검사 */
	public int idCheck(String user_id);
	
	/* 로그인 */
	public userVO Login(userVO user);
	
	/* 회원 탈퇴 */
	public void userDelete(userVO user);
}
