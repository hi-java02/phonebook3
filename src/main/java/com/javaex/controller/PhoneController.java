package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	//피드
	//생성자
	//메소드-g.s
	
	/**메소드 일반****메소드 마다 기능 1개씩 --> 기능마다 url 부여********/

	//리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("list");
		
		//doa를 통해 리스트 를 가져온다.
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());
		
		//model -->data 를 보내는 방법 -->담아 놓으면 된다
		model.addAttribute("pList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}

	
	//등록폼
	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String writeFrom() {
		System.out.println("writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}

	//http://localhost:8088/phonebook3/phone/write?name=황일영&hp=999-9999-9999&company=888-8888-8888
	//등록
	@RequestMapping(value = "write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name, 
			            @RequestParam("hp") String hp, 
			            @RequestParam("company") String company) {

		System.out.println("write");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo.toString());
		
		PhoneDao phoneDao = new PhoneDao();
	    phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	
	//수정폼 --> modifyForm
	
	//수정 --> modify
	
	//삭제 --> delete
	

	

	
	
	//등록
	
	//수정폼
	
	//수정
	
	//삭제
	
	
	
	
	
	
}
