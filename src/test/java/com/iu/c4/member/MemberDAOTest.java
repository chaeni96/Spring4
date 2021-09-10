package com.iu.c4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.c4.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void getIdCheck() throws Exception{
		MemberDTO memberDTO  = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO = memberDAO.getIdCheck(memberDTO);
		assertNotNull(memberDTO);
	}

}
