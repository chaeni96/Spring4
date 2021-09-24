package com.iu.c4.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.c4.board.BoardDTO;
import com.iu.c4.board.BoardFilesDTO;
import com.iu.c4.board.BoardService;
import com.iu.c4.board.CommentsDTO;
import com.iu.c4.util.FileManager;
import com.iu.c4.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return noticeDAO.getList(pager);
	}
	
	@Override
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		//1. 어느 폴더 /resources/upload/notice 
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		int result = noticeDAO.setInsert(boardDTO);
		
		
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		return  result; 
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		//Files Table에서 삭제할 파일명들 조회
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		//어느 폴더 
		String realPath = servletContext.getRealPath("/resources/upload/notice/");
		
		for(BoardFilesDTO bFilesDTO: ar ) {
			File file = new File(realPath, bFilesDTO.getFileName());
			fileManager.fileDelete(file);
		}
		
		//DB 삭제
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setReply(BoardDTO boardDTO) throws Exception{
		return 0;
	}
	
	//오버라이딩 하기
	public int setComment(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setComment(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception{
		pager.setPerPage(5L);
		pager.makeRow();
		//전체 댓글의 개수
		pager.makeNum(noticeDAO.getCommentCount(commentsDTO));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		return noticeDAO.getCommentList(map);
	}
	
	public int setCommentDel(CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentDel(commentsDTO);
	}
	
	public int setCommentUpdate (CommentsDTO commentsDTO) throws Exception{
		return noticeDAO.setCommentUpdate(commentsDTO);
	}

}
