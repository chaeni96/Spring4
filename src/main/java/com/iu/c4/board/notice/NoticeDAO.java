package com.iu.c4.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.c4.board.BoardDAO;
import com.iu.c4.board.BoardDTO;
import com.iu.c4.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession SqlSession;
	private final String NAMESPACE="com.iu.c4.board.notice.NoticeDAO.";
	
	@Override
	public Long getCount(Pager pager) throws Exception{

		return SqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return SqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
