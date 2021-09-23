package com.iu.c4.board;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.c4.MyJunitTest;
import com.iu.c4.board.notice.NoticeDAO;

public class CommentDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception {
		for(int i=0; i<100;i++ ) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(202L);
			commentsDTO.setWriter("c2");
			commentsDTO.setContents("comments"+i);
			commentsDTO.setBoard("N");
			noticeDAO.setComment(commentsDTO);
			
			if(i%10 == 0) {
			Thread.sleep(1000);
			}
		}
		System.out.println("Finish");
	}
}
