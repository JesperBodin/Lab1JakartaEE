package se.iths.laboration1.dto;


import se.iths.laboration1.entity.Game;

public class GameDto {

	private final Long id;
	private final String name;
	private final String shortening;

	public GameDto(Game game) {
		this.id = game.getId();
		this.name = game.getName();
		this.shortening = game.getShortening();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortening() {
		return shortening;
	}
}
