package com.ktdsuniversity.edu.homework_spring.bbs.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.homework_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework_spring.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.homework_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

@Import({BoardDaoImpl.class, BoardServiceImpl.class})
@SpringBootTest
public class BoardServiceImplTest {

	@Autowired
	BoardService boardService;
	
	@MockBean
	BoardDao boardDao;
	
	@Test
	public void testCreateNewBoard() {
		WriteBoardVO writeBoardVO = new WriteBoardVO();
		
		BDDMockito.given(boardDao.createNewBoard(writeBoardVO)).willReturn(1);
		
		assertEquals(true, boardService.createNewBoard(writeBoardVO));
	}
}
