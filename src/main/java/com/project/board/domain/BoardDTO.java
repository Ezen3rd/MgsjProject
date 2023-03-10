package com.project.board.domain;

import java.util.Date;

/**
 * 
 * @author 김재국, 정원진, 홍준영
 *
 */

public class BoardDTO {

	private int bno;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int readCount;
	private int boardLevel;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(int boardLevel) {
		this.boardLevel = boardLevel;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", readCount="
				+ readCount + ", boardLevel=" + boardLevel + "]";
	}

}
