package com.iu.c4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.c4.board.BoardDTO;
import com.iu.c4.board.BoardFilesDTO;
import com.iu.c4.board.BoardService;
import com.iu.c4.util.FileManager;
import com.iu.c4.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getFiles(boardDTO);
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		String realPath = servletContext.getRealPath("/resources/upload/qna/");
		
		File file = new File(realPath);
		
		int result = qnaDAO.setInsert(boardDTO);
		
		for(MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFile(boardFilesDTO);
		}
		
		return result;
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
	
	public int setReply(QnaDTO qnaDTO)throws Exception{
		//1. 부모의 정보 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}

}
