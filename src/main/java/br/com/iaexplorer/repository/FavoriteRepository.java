package br.com.iaexplorer.repository;

import br.com.iaexplorer.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
