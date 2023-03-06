package se.iths.laboration1.dto;


import se.iths.laboration1.entity.Game;

public class GameDto {

	private  Long id;
	private  String name;
	private  String shortening;

	public GameDto(Game game) {
		this.id = game.getId();
		this.name = game.getName();
		this.shortening = game.getShortening();
	}

	public GameDto() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortening(String shortening) {
		this.shortening = shortening;
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
