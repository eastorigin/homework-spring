package com.ktdsuniversity.edu.homework_spring.bbs.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testCreateNewBoard() {
		BoardVO boardVO = new BoardVO();
		boardVO.setSubject("제목 테스트");
		boardVO.setContent("내용 테스트");
		boardVO.setEmail("email@test.com");
		
		assertEquals("제목 테스트", boardVO.getSubject());
		assertEquals("내용 테스트", boardVO.getContent());
		assertEquals("email@test.com", boardVO.getEmail());
	}
}
