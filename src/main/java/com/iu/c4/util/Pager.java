package com.iu.c4.util;

public class Pager {
	
	private Long pn; //현재 page
	private Long perPage; //page당 보여지는 개수
	private Long startRow; //게시글의 시작번호
	private Long lastRow; //게시글의 끝번호
	private Long startNum; 
	private Long lastNum;
	
	private Long totalPage; //page의 총 개수
	
	private String kind;
	private String search;
	
	//선택한 페이지에서 보이는 게시글의 시작번호, 끝번호 
	public void makeRow() {
		this.startRow = (this.getPerPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}
	
	
	public void makeNum(Long totalCount) {
		
		//page 개수 구하기
		totalPage = totalCount/this.getPerPage(); //totalCount=table의 총개수
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
			
		//totalBlock 구하기
			Long totalBlock = totalPage/5;
			if(totalPage%5 !=0) {
				totalBlock++;
			}
			
		//pn으로 curBlock 구하기
		
		Long curBlock = this.getPn()/5;
		if(this.getPn()%5 !=0) {
			curBlock++;
		}
		
	//5. curBlock으로 시작번호와 마지막 번호 구하기
		
		this.startNum=(curBlock-1)*5+1;
		this.lastNum = curBlock*5;
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	
	}
	
	//pn의 값에 1 미만의 숫자를 넣었을경우 1로 설정 
	public Long getPn() {
		if(this.pn ==null || this.pn<=0) {
			this.pn = 1L;
		}
		
		return pn;
	}
	public void setPn(Long pn) {
		this.pn = pn;
	}
	
	//한 페이지당 보이는 게시글 개수 - 10개로 기본세팅
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
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
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		return search;
	}
	//검색시 아무것도 안넣었을때 전체 페이지 보이도록
	public void setSearch(String search) {
		if(this.search == null) {
			this.search = "";
		}
		this.search = search;
	}
	
	

}
