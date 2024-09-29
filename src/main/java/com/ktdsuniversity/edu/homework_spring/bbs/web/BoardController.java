package com.ktdsuniversity.edu.homework_spring.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.homework_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework_spring.bbs.vo.WriteBoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board/list")
	public ModelAndView viewBoardList() {
		BoardListVO boardListVO = boardService.getAllBoard();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardlist");
		modelAndView.addObject("boardList", boardListVO);
		return modelAndView;
	}
	
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write")
	public ModelAndView doBoardWirte(@ModelAttribute WriteBoardVO writeBoardVO) {
		System.out.println("제목: " + writeBoardVO.getSubject());
		System.out.println("이메일: " + writeBoardVO.getEmail());
		System.out.println("내용: " + writeBoardVO.getContent());
		
		ModelAndView modelAndView = new ModelAndView();
		
		boolean isSuccess = boardService.createNewBoard(writeBoardVO);
		if(isSuccess) {
			modelAndView.setViewName("redirect:/board/list");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("board/boardwrite");
			modelAndView.addObject("writeBoardVO", writeBoardVO);
			return modelAndView;
		}
	}
	
	@GetMapping("/board/view")
	public ModelAndView viewOneBoard(@RequestParam int id) {
		BoardVO boardVO = boardService.getOneBoard(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardview");
		modelAndView.addObject("boardVO", boardVO);
		return modelAndView;
	}
}
