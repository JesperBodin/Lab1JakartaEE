package se.iths.laboration1.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.iths.laboration1.entity.Game;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class GameRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Game> findAll() {
		var query = entityManager.createQuery("SELECT g from Game g");
		return (List<Game>) query.getResultList();

	}

	public Optional<Game> findOne(Long id) {
		return Optional.ofNullable(entityManager.find(Game.class, id));
	}

	public void insertGame(Game game) {
		entityManager.persist(game);
	}

	public void deleteGame(Long id) {
		var game = findOne(id);
		game.ifPresent((g) -> entityManager.remove(g));
	}

	public Game update(Long id, Game game) {
		var entity = entityManager.find(Game.class, id);
		entity.setName(game.getName());
		entity.setShortening(game.getShortening());
		entityManager.persist(entity);
		return entity;
	}
}
