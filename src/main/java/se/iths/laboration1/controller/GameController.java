package se.iths.laboration1.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.iths.laboration1.entity.Game;
import se.iths.laboration1.dto.GameDto;
import se.iths.laboration1.repository.GameRepository;
import se.iths.laboration1.dto.GameMapper;
import java.net.URI;
import java.util.List;

@Path("/games")
public class GameController {
	@Inject
	GameRepository repository;
	@Inject
	GameMapper mapper;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GameDto> getAll() {
		return mapper.map(repository.findAll());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("id") Long id) {
		var game = repository.findOne(id);
		if (game.isPresent())
			return Response.ok().entity(mapper.map(game.get())).build();
		throw new NotFoundException(Response.status(404).build());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOne(@Valid Game game) {
		repository.insertGame(game);
		return Response.created(URI.create("/games" + game.getId())).build();
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		repository.deleteGame(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGame(@PathParam("id") Long id, GameDto gameDto) {
		var game = repository.findOne(id);
		if (game.isPresent())
			return Response.ok().entity(mapper.map(repository.update(id, mapper.map(gameDto)))).build();
		throw new NotFoundException(Response.status(404).build());
	}
}
