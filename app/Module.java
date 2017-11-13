import java.time.Clock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import play.libs.Json;
import repositories.IUsersRepository;
import repositories.fake.UsersRepository;
import services.ApplicationTimer;
import services.AtomicCounter;
import services.Counter;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
//        this.initJsonMapper();
        this.bindRepositories();
        
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);
    }
    
    private void initJsonMapper()
    {
        ObjectMapper mapper = Json.newDefaultMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        Json.setObjectMapper(mapper);
    }
    
    private void bindRepositories()
    {
        bind(IUsersRepository.class).to(UsersRepository.class).in(Singleton.class);
    }

}
