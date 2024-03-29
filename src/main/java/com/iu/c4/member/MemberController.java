package com.iu.c4.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO) throws Exception{
		//중복검사할 id 출력
		
		System.out.println(memberDTO.getId());
		memberDTO = memberService.getIdCheck(memberDTO);
		//1이면 사용가능
		//0이면 사용불가(중복)
		int result = 0;
		if(memberDTO == null) {
			result = 1;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복 체크");
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{
		// 매개변수로  HttpServletRequest request 받았을때는 HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	//logout
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		//1. session 제거 방법
		//session.removeAttribute("member");
		
		//2. session의 시간을 0으로 만드는 방법
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("check")
	public ModelAndView check() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv;
	}
	
	//------------join
	@GetMapping("join")
	public ModelAndView join() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv;
	}
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		
		/*
		 * String original = photo.getOriginalFilename(); String name = photo.getName();
		 * long size = photo.getSize();
		 * 
		 * System.out.println("Original : "+original);
		 * System.out.println("name : "+name); System.out.println("size : "+size);
		 */
		
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session);
	
		String message = "회원가입 실패";
		
		if(result >0) {
			message = "회원가입 성공";
		}
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	//-------------------mypage
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
	
	//------------------mypage 수정
	@GetMapping("modify")
	public ModelAndView modify(ModelAndView mv) throws Exception{
		mv.setViewName("member/modify");
		return mv;
	}
	
	@PostMapping("modify")
	public ModelAndView modify(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//수정전 데이터
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		//수정 후 데이터
		memberDTO.setId(sessionDTO.getId());
		int result = memberService.setUpdate(memberDTO);
		memberDTO.setName(sessionDTO.getName());
		
		session.setAttribute("member", memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	//--------------------탈퇴
	@GetMapping("delete")
	public ModelAndView delete(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.setDelete(memberDTO);
		session.invalidate();
		/* session.invalidate 대신 mv.setViewName("redirect: ./logout"); */
		mv.setViewName("redirect: ../");
		return mv;
	}

}
