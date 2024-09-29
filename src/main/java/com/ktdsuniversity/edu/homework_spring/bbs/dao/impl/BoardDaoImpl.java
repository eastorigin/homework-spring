package com.ktdsuniversity.edu.homework_spring.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int getBoardAllCount() {
		return 0;
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		return null;
	}
	
	@Override
	public int createNewBoard(WriteBoardVO writeBoardVO) {
		return getSqlSession().insert("com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao.createNewBoard", writeBoardVO);
	}
	
	@Override
	public int increaseViewCount(int id) {
		return getSqlSession().update("com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao.increaseViewCount", id);
	}
	
	@Override
	public BoardVO getOneBoard(int id) {
		return getSqlSession().selectOne("com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao.getOneBoard", id);
	}
}
