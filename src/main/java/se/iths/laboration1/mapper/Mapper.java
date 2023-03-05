package se.iths.laboration1.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.iths.laboration1.game.Game;
import se.iths.laboration1.game.GameDto;

import java.util.List;

@ApplicationScoped
public class Mapper {

	public List<GameDto> map(List<Game> all){
		return all.stream().map(GameDto::new).toList();
	}
	public GameDto map(Game game) {
		return new GameDto(game);
	}
	public Game map(GameDto game) {
		var g = new Game();
		g.setId( game.getId());
		g.setName(game.getName());
		g.setShortening(game.getShortening());
		return g;
	}
}
