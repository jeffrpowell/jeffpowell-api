package dev.jeffpowell.api;

import javax.ws.rs.ApplicationPath;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class AppConfig extends ResourceConfig{
    public AppConfig() {
        super(ObjectMapperProvider.class, JacksonFeature.class, MultiPartFeature.class);
        packages("dev.jeffpowell.api.resource");
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
        register(new AppBinder());
    }
}
