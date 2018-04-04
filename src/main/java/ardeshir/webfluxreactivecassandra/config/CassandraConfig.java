package ardeshir.webfluxreactivecassandra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "testspace";
    }
}
