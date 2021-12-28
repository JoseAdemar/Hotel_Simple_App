package hotel.simple.app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;

@ApplicationScoped
public class HotelSimpleApp {
	
	private static final Logger LOG = Logger.getLogger(HotelSimpleApp.class);
	
	void onStart(@Observes StartupEvent ev) {
		LOG.info("The application is starting with profile '" + ProfileManager.getActiveProfile() + "'");
	}

}
