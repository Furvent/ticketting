package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
