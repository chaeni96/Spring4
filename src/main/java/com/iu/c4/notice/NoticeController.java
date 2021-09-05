package com.iu.c4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.c4.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//목록
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv, Pager pager) {
		List<NoticeDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//상세정보
	@RequestMapping("select")
	public String select(NoticeDTO noticeDTO, Model model) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/select";
	}
	
	//게시글 작성(작성폼 페이지로)
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "board/insert";
	}
	
	//게시글 작성(작성 후 다시 목록페이지로)
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO) {
		int result = noticeService.setInsert(noticeDTO);
		
		return "redirect:./list";
	}
	
	//게시글 삭제(삭제후 목록페이지로)
	@RequestMapping(value = "delete")
	public String delete(NoticeDTO noticeDTO) {
		int result = noticeService.setDelete(noticeDTO);
		
		return "redirect:./list";
	}
	
	//게시글 수정(수정폼으로)
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mv, NoticeDTO noticeDTO){
		mv.setViewName("board/update");
		mv.addObject("dto", noticeDTO);
		return mv;
		
	}
	
	//게시글 수정(수정후 다시 목록으로)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) {
		int result = noticeService.setUpdate(noticeDTO);
		
		return "redirect:./list";
	}
	
}
