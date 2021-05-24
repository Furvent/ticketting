package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Comment;

public interface CommentService {
	public Comment save(Comment comment);
	public List<Comment> getAllComments();
	public Comment getCommentById(Long groupId);
	public void delete(Comment comment);
	public Comment update(Comment comment);
}
