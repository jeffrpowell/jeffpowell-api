package dev.jeffpowell.api;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.jeffpowell.api.dao.TechDao;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class AppBinder extends AbstractBinder {

    @Override
    protected void configure() {
        try {
            bindMongoClient();
        }
        catch (Exception e) {
            System.err.println(e);
        }
		bind(TechDao.class).to(TechDao.class);
    }

    private void bindMongoClient() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .build();
        bind(MongoClients.create(settings)).to(MongoClient.class);
    }

}
