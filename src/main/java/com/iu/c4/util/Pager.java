package com.iu.c4.util;

public class Pager {
	
	//현재 보는 페이지의 번호
	private Long pn;

	//한페이지에 출력할 글의 개수(한 페이지에서 보이는) 
	private Long perPage;
	
	//한페이지에 출력할 pn의 개수(한 페이지에 보이는) 
	private Long perBlock;
	
	//-------------- RowNum Mapper에서 사용----------
	
	private Long startRow;
	private Long lastRow;
	
	//------------- startNum, lastNum(jsp 번호 출력때 사용)

	private Long startNum;
	private Long lastNum;
	
	private Long totalBlock;
	private Long totalPage;
	
	//------------ 검색 ---------------
	private String kind;
	private String search;
	
	//--------- rowNum 계산 ---------------
	
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}

	public void makeNum(Long totalCount) {
		//1. totalCount : 전체 글의 개수 (매개변수로 받아옴)
		//2. totalCount 로 totalPage 계산 : 전체 페이지 개수
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0 ) {
			totalPage++;
		}
		
		//3. totalPage로 totalBlock 계산
		totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() !=0 ) {
			totalBlock++;
		}
		
		//4-1. pn으로 현재 블럭 번호 구하기
		
		if(totalPage< this.getPn()) {
			this.setPn(totalPage);
		}
		//4-2
		Long curBlock = this.getPn()/this.getPerBlock();
		if(this.getPn()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 StartNum, lastNum 계산
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6. curBlock이 마지막 Block일때 lastNum 변경
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	
	// ------------- Setter, Getter----------------
	
	//입력한 페이지의 숫자가 1보다 작거나 null이 들어와도 1로 치환
	public Long getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1L;
		}
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}

	
	public Long getPerPage() {
		this.perPage = 10L;
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		this.perBlock=5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Long totalBlock) {
		this.totalBlock = totalBlock;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	//검색시 아무것도 안넣었을때 전체 페이지 보이도록
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	
	
}
