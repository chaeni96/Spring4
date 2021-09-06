package com.iu.c4.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.iu.c4.MyJunitTest;
import com.iu.c4.util.Pager;

public class NoticeDAOTest extends MyJunitTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void getListTest(Pager pager) {
		List<NoticeDTO> ar = noticeDAO.getList(pager);
		assertNotEquals(0, ar.size());
		}
		
		
	
	//@Test
	public void getSelectTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);	
	}
	
	@Test
	public void setInsertTest() throws Exception {

		for(int i = 0; i<200; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("Title"+i);
			noticeDTO.setContents("Contents"+i);
			noticeDTO.setWriter("Writer"+i);
			int result = noticeDAO.setInsert(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
				}
		}
	}
	
	//@Test
	public void setDeleteTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setUpdateTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3L);
		noticeDTO.setTitle("Update Title");
		noticeDTO.setContents("Update Contents");
		noticeDTO.setWriter("Update Writer");
		
		int result = noticeDAO.setUpdate(noticeDTO);
		
		assertNotEquals(0, result);
	}

}
