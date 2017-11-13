package modules;

import com.google.inject.AbstractModule;

public class JsonObjectMapperModule extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(JsonObjectMapper.class).asEagerSingleton();
    }

}
