
package se.iths.laboration1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "name can't be null")
	private String name;
	@NotNull(message = "shortening can't be null")
	@Size(max = 10)
	private String shortening;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortening() {
		return shortening;
	}

	public void setShortening(String shortening) {
		this.shortening = shortening;
	}
}
