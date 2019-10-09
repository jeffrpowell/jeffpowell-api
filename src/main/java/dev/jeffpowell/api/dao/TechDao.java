package dev.jeffpowell.api.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.jeffpowell.api.model.KnownTech;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jvnet.hk2.annotations.Service;

@Service
public class TechDao {
	
	private final MongoCollection<KnownTech> knownTechCollection;
	
	@Inject
	public TechDao(MongoClient client) {
		MongoDatabase db = client.getDatabase("jeffpowell");
		this.knownTechCollection = db.getCollection("knownTech", KnownTech.class);
	}
	
	public List<KnownTech> getKnownTechnologies() {
		return knownTechCollection.find().into(new ArrayList<>());
	}
}
