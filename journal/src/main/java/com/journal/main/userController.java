package com.journal.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.journal.model.userVO;
import com.journal.service.userService;

@Controller
@RequestMapping("/user/*")
public class userController {

	private static final Logger log = LoggerFactory.getLogger(userController.class);
	
	@Autowired
	private userService uservice;
	
	/* 회원가입 페이지 이동 임시 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void RegisterGET() {
		//
	}
	
	/* 로그인 페이지 이동 임시 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
		//
	}
	
	/* 회원가입 등록 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String RegisterPOST(userVO user) throws Exception {
		uservice.register(user);
		
		/* 페이지 이동 처리 */
		return "";
	}
	
	/* 아이디 중복 검사 */
	@RequestMapping(value="/user_idCk", method=RequestMethod.POST)
	@ResponseBody
	public String user_idCkPOST(String user_id) throws Exception {
		int result = uservice.idCheck(user_id);
		if(result != 0) {
			return "Fail"; //아이디 중복
		} else {
			return "Success"; //고유 아이디
		}
	}
	
	/* 로그인 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, userVO user, RedirectAttributes rttr) throws Exception {
		HttpSession session = request.getSession();
		userVO uvo = uservice.Login(user);
		
		if(uvo == null) { //아이디, 비밀번호 불일치
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return ""; //로그인 페이지 경로
		}
		session.setAttribute("user", uvo); //로그인 성공
		return ""; //피드라인 페이지 경로
	}
	
	/* 탈퇴 */
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public void deleteGET() throws Exception{	
		//
	}
	
	/* 탈퇴 */
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void deletePOST(userVO user) throws Exception {
		uservice.userDelete(user);
	}
	
}
