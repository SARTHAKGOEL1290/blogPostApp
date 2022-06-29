package blogPostApp.helper;

import java.util.List;

import blogPostApp.dto.PostsDTO;

public class PostResponse {
	
	private List<PostsDTO> content;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private int totalElements;
	private boolean lastPage;
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostResponse(List<PostsDTO> content, int pageNumber, int pageSize, int totalPages, int totalElements,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.lastPage = lastPage;
	}
	public List<PostsDTO> getContent() {
		return content;
	}
	public void setContent(List<PostsDTO> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	

}
