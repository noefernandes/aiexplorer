package br.com.iaexplorer.repository;

import br.com.iaexplorer.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
