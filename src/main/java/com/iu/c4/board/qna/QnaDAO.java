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
	private SqlSession sqlSession;
	private final String NAMESAPCE = "com.iu.c4.board.qna.QnaDAO.";
	
	
	@Override
	public Long getCount(Pager pager) throws Exception {
	
		return sqlSession.selectOne(NAMESAPCE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		return sqlSession.selectList(NAMESAPCE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {

		return sqlSession.selectOne(NAMESAPCE+"getSelect", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESAPCE+"setInsert", boardDTO);
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
	
	public int setReplyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESAPCE+"setReplyUpdate", qnaDTO );
	}
	
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE+"setReply", qnaDTO);
	}
	
	//조회수 업데이트
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESAPCE+"setHitUpdate", boardDTO);
	}

}
