package se.iths.laboration1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;

@Path("/games")
public class GameResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Games";
    }
}
