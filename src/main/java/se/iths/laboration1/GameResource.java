package se.iths.laboration1;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.sql.Update;
import se.iths.laboration1.game.Game;
import se.iths.laboration1.game.GameDto;
import se.iths.laboration1.game.GameRepository;
import se.iths.laboration1.mapper.Mapper;

import java.awt.*;
import java.net.URI;
import java.util.List;

@Path("/games")
public class GameResource {

	@Inject
	GameRepository repository;

	@Inject
	Mapper mapper;

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
			return Response.ok().entity(game.get()).build();
		return Response.status(404).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addOne(@Valid Game game) {
		repository.insertGame(game);
		return Response.created(URI.create("/games" + game.getId())).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteOne(@PathParam("id") Long id) {
		repository.deleteGame(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, GameDto game) {
		return Response.ok().entity(mapper.map(repository.update(id, mapper.map(game)))).build();

	}
}
