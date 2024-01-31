package br.com.iaexplorer.repository;

import br.com.iaexplorer.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
