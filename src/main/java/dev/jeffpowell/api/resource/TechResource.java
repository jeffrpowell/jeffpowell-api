package dev.jeffpowell.api.resource;

import dev.jeffpowell.api.dao.TechDao;
import dev.jeffpowell.api.model.KnownTech;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tech")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TechResource {
	
	private final TechDao techDao;
	
	@Inject
	public TechResource(TechDao techDao) {
		this.techDao = techDao;
	}
	
	@GET
	public List<KnownTech> getKnownTechnologies() {
		return techDao.getKnownTechnologies();
	}
}
