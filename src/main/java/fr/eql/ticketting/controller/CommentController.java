package fr.eql.ticketting.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Comment;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.service.CommentService;

@Controller
public class CommentController {
	CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping("/list-comment")
	public String displayGroups(Model model) {
		List<Comment> comments = commentService.getAllComments();
		model.addAttribute("comments", comments);
		return "commentList"; 
	}
}
