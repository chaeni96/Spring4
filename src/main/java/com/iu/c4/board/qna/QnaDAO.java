package com.iu.c4.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.c4.board.BoardDAO;
import com.iu.c4.board.BoardDTO;
import com.iu.c4.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession SqlSession;
	private final String NAMESAPCE = "com.iu.c4.board.qna.QnaDAO.";
	
	
	@Override
	public Long getCount(Pager pager) throws Exception {
	
		return SqlSession.selectOne(NAMESAPCE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return SqlSession.selectList(NAMESAPCE+"getList", pager);
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
	
	//답글
	public int setReply(QnaDAO qnaDAO) throws Exception {
		return 0;
	}
	
}
