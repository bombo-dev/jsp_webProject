package service;

public class Paging {
	private int perPage = 20; 		// 화면 당 게시글 수
	private int pageCount; 			// 총 페이지 개수
	private int boardCount;			// 총 게시글 수
	private int first;				// 현 페이지의 첫번째 게시글
	private int last; 				// 현 페이지의 마지막 게시글
	
	private int perSection = 5;		// 화면당 페이지 수
	private int begin;				// 페이지 시작 번호
	private int end;				// 페이지 마지막 번호
	private int section;			// 현 페이지 인덱스 1~5 0번 인덱스 6~10 1번 인덱스
	private int page;				// 사용자가 요청한 페이지
	
	private boolean prev, next;		// 이전, 다음 페이지가 있나?
	
	public Paging(int page, int boardCount) {
		this.page = page;
		this.boardCount = boardCount;
		
		pageCount = boardCount / perPage; // 총 게시글 수와 화면에 표시할 게시글 수를 나눈 것이 페이지 개수이다.
		pageCount += (boardCount % perPage == 0) ? 0 : 1; // 나눈 값은 정수로 들어오기 때문에 화면에 표시할 게시글 수가 초과되었을 때 페이지 수를 1개 더 늘려준다.		
		first = (page - 1) * perPage + 1;
		last = page * perPage;
		
		section = (page - 1) / perSection; // 사용자가 요청한 페이지가 perSection만큼 넘어갈때마다 인덱스가 1씩 올라간다.
		begin = perSection * section + 1; // [0]:1 
		end = (section + 1) * perSection;
		
		end = (end > pageCount) ? pageCount : end; // 섹션에 나올 페이지 마지막 번호가 총 페이지 개수보다 작을 경우를 산정해준다.
		
		prev = (section != 0);
		next = (boardCount > perPage * end);
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPerSection() {
		return perSection;
	}

	public void setPerSection(int perSection) {
		this.perSection = perSection;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
}
