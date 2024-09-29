package com.ktdsuniversity.edu.homework_spring.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		
		BoardListVO boardListVO = new BoardListVO();
		
		boardListVO.setBoardCnt(boardDao.getBoardAllCount());
		
		boardListVO.setBoardList(boardDao.getAllBoard());
		
		return boardListVO;
	}
	
	@Override
	public boolean createNewBoard(WriteBoardVO writeBoardVO) {
		int createCount = boardDao.createNewBoard(writeBoardVO);
		return createCount > 0;
	}
	
	@Override
	public BoardVO getOneBoard(int id) {
		int updateCount = boardDao.increaseViewCount(id);
		if(updateCount == 0) {
			throw new IllegalArgumentException("잘못된 접근입니다");
		}
		BoardVO boardVO = boardDao.getOneBoard(id);
		return boardVO;
	}

}
