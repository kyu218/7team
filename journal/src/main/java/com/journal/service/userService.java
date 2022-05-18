package com.journal.service;

import com.journal.model.userVO;

public interface userService {
	
	/* 회원가입 */
	public void register(userVO user) throws Exception;
	
	/* 아이디 중복 검사 */
	public int idCheck(String user_id) throws Exception;
	
	/* 로그인 */
	public userVO Login(userVO user) throws Exception;
	
	/* 회원 탈퇴 */
	public void userDelete(userVO user) throws Exception;
}
