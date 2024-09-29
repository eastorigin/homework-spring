package com.ktdsuniversity.edu.homework_spring.bbs.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testCreateNewBoard() {
		WriteBoardVO writeBoardVO = new WriteBoardVO();
		writeBoardVO.setSubject("제목 테스트");
		writeBoardVO.setContent("내용 테스트");
		writeBoardVO.setEmail("email@test.com");
		
		int insertCount = this.boardDao.createNewBoard(writeBoardVO);
		
		assertTrue(insertCount == 1);
		System.out.println("insertCount 개수: " + insertCount);
		
		assertEquals("제목 테스트", writeBoardVO.getSubject());
		assertEquals("내용 테스트", writeBoardVO.getContent());
		assertEquals("email@test.com", writeBoardVO.getEmail());
	}
}
