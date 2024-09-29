package com.ktdsuniversity.edu.homework_spring.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

public interface BoardDao {

	public int getBoardAllCount();
	
	public List<BoardVO> getAllBoard();
	
	public int createNewBoard(WriteBoardVO writeboardVO);
	
	public int increaseViewCount(int id);
	
	public BoardVO getOneBoard(int id);
}
