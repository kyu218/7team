package com.journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journal.mapper.userMapper;
import com.journal.model.userVO;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private userMapper mapper;
	
	/* 회원가입 */
	@Override
	public void register(userVO user) throws Exception {
		mapper.register(user);
	}
	
	/* 아이디 중복 검사 */
	@Override
	public int idCheck(String user_id) throws Exception {
		return mapper.idCheck(user_id);
	}
	
	/* 로그인 */
	@Override
	public userVO Login(userVO user) throws Exception {
		return mapper.Login(user);
	}
	
	/* 회원 탈퇴 */
	@Override
	public void userDelete(userVO user) throws Exception {
		mapper.userDelete(user);
	}
}
