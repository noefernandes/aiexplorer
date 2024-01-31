package br.com.iaexplorer.repository;

import br.com.iaexplorer.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
