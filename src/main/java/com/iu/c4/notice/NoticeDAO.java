package com.iu.c4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.c4.notice.NoticeDAO.";
	
	//공지사항 목록 전체 보기
	public List<NoticeDTO> getList() {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	//선택한 게시물 상세내용 보기
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	//게시글 작성
	public int setInsert(NoticeDTO noticeDTO) {
		
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
}
