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
}
