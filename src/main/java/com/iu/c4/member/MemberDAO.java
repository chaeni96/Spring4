package com.iu.c4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.c4.member.MemberDAO.";
	
	//id중복 확인
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO);
	}
	
	//login
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	//file 첨부	
	public int setFileInsert(MemberFilesDTO memberFilesDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFilesDTO);
	}
	
	//mypage 수정
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
	}
	
	//탈퇴
	public int setDelete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", memberDTO);
	}
	
	//mypage에서 이미지 보기
	public MemberFilesDTO getFile(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getFile", memberDTO);
	}

}
